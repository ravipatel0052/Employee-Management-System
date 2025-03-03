package com.ravi.basic.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ravi.basic.dao.EmployeeDao;
import com.ravi.basic.dao.EmployeeDaoImp;
import com.ravi.basic.model.Employee;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		
		Integer empNo = Integer.parseInt(req.getParameter("emp_no"));
		String empName = req.getParameter("emp_name");
		Double empSal = Double.parseDouble(req.getParameter("emp_sal"));
		
		Employee employee=new Employee();
		employee.setEmpNo(empNo);
		employee.setEmpName(empName);
		employee.setEmpSal(empSal);
		
		try {
			EmployeeDao employeeDao = new EmployeeDaoImp();
			String msg = employeeDao.updateEmployee(employee);
			sc.setAttribute("usermsg", msg);
			res.sendRedirect("mainController");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			}
			
		}
}
