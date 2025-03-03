package com.ravi.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
@WebServlet("/find")
public class FindController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		
		Integer empNo = Integer.parseInt(req.getParameter("emp_no"));
		
		try {
			EmployeeDao employeeDao = new EmployeeDaoImp();
			Employee msg = employeeDao.findRecord(empNo);
			sc.setAttribute("msg", msg);
			RequestDispatcher rd = req.getRequestDispatcher("updateView");
			rd.forward(req, res);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
