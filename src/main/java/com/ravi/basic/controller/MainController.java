package com.ravi.basic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ravi.basic.dao.EmployeeDao;
import com.ravi.basic.dao.EmployeeDaoImp;
import com.ravi.basic.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/mainController")
public class MainController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		
		String username = (String) sc.getAttribute("username");
		sc.setAttribute("username", username);
		
		String usermsg = (String) sc.getAttribute("usermsg");
		sc.setAttribute("usermsg", usermsg);
	
		try {
			EmployeeDao employeeDao = new EmployeeDaoImp();
			List<Employee> employees = employeeDao.AllEmployee();
			sc.setAttribute("employees", employees);
			RequestDispatcher rd = req.getRequestDispatcher("mainView");
			rd.forward(req, res);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			}
		
	}
}
