package com.ravi.basic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.ravi.basic.dao.EmployeeDao;
import com.ravi.basic.dao.EmployeeDaoImp;
import com.ravi.basic.model.Employee;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/mainView")
public class MainView extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ServletContext sc=getServletContext();
		
		String logUser = (String) sc.getAttribute("username");
		List<Employee> employees=(List<Employee>) sc.getAttribute("employees");
		
		out.println("<html>");
		out.println("<body style='background-color:#BACD92;padding:50px;'>");
		out.println("<table style='border:3px groove black;border-collapse:collapse;background-color:#F5DAD2;width:70vw;margin:auto;'>");
		out.println("<caption style='color:blue;font-size:3vw;'>Employee Details</caption>");
		if(!employees.isEmpty()) {
			
			out.println("<tr><td colspan='1' style='border: none;padding:15px;'><a href='add.html' style='border-radius: 8px; padding:7px;background-color:green;color:white;text-decoration: none;'> Add Record </a></td>");
			out.println("<td colspan='1' style='color:green;font-size:25px;text-align:right;padding:10px;'>Message:</td>");
			
			if(sc.getAttribute("usermsg")!=null) {
				out.println("<td colspan='3' style='color:red;font-size:20px;padding:15px;'>"+(String) sc.getAttribute("usermsg")+"</td></tr>");
			}else {
				out.println("<td colspan='3' style='color:red;font-size:20px;padding:15px;'>Welcome  "+logUser+"</td></tr>");
			}
		
			out.println("<tr style='border: 2px groove black;color:green;font-size:20px'>");
			out.println("<th style='border: 2px groove black;padding:10px;'>Employee Number</th>");
			out.println("<th style='border: 2px groove black;'>Employee Name</th>");
			out.println("<th style='border: 2px groove black;'>Employee Salary</th>");
			out.println("<th colspan='2' style='border: 2px groove black;padding:7px;'>Options</th>");
			out.println("</tr>");	
			
			for(Employee employee: employees) {
				out.println("<tr style='border: 2px groove black;color:red;text-align:center;'>");
				out.println("<td style='border: 2px groove black;'>"+employee.getEmpNo()+"</td>");
				out.println("<td style='border: 2px groove black;'>"+employee.getEmpName()+"</td>");
				out.println("<td style='border: 2px groove black;'>"+employee.getEmpSal()+"</td>");
				
				out.println("<td style='border: 2px groove black;'>");
				out.println("<form method='post' action='find' style='margin-block-end: 0px;margin:2px;'><input type='hidden' name='emp_no' value='"+employee.getEmpNo()+"'>");
				out.println("<input type='submit' value='Update' style='background-color:rgb(191,191,0);border-radius: 8px;'></form>");
				out.println("</td>");
				
				out.println("<td style='border: 2px groove black;'>");
				out.println("<form method='post' action='delete' style='margin-block-end: 0px;margin:2px;'><input type='hidden' name='emp_no' value='"+employee.getEmpNo()+"'>");
				out.println("<input type='submit' value='Delete' style='background-color:red;border-radius: 8px;'></form>");
				out.println("</td>");

			}
		
		}else {
			out.println("<tr><td colspan='1' style='border: none;padding:15px;'><a href='addView' style='border-radius: 8px; padding:7px;background-color:green;color:white;text-decoration: none;'> Add Record </a></td>");
			out.println("<td colspan='1' style='color:green;font-size:25px;text-align:right;padding:10px;'>Message:</td>");
			if(sc.getAttribute("usermsg")!=null) {
				out.println("<td colspan='3' style='color:red;font-size:20px;padding:15px;'>"+(String) sc.getAttribute("usermsg")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Data Not Exist, Please Enter Data...</td></tr>");
			}else {
				out.println("<td colspan='3' style='color:red;font-size:20px;padding:15px;'>Welcome  "+logUser+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Data Not Exist, Please Enter Data...</td></tr>");
			}
			
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
