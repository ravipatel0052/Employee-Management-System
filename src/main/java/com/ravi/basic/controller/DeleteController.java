package com.ravi.basic.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ravi.basic.dao.EmployeeDao;
import com.ravi.basic.dao.EmployeeDaoImp;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		
		Integer empNo = Integer.parseInt(req.getParameter("emp_no"));
		
		
		
		try {
			EmployeeDao employeeDao = new EmployeeDaoImp();
			String msg = employeeDao.deleteEmployee(empNo);
			sc.setAttribute("usermsg", msg);
			res.sendRedirect("mainController");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
