package com.ravi.basic.view;

import java.io.IOException;
import java.io.PrintWriter;

import com.ravi.basic.model.Employee;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/updateView")
public class UpdateView extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ServletContext sc=getServletContext();
		
		Employee employee =(Employee) sc.getAttribute("msg");
		Integer empNo = employee.getEmpNo();
		String empName = employee.getEmpName();
		Double empSal = employee.getEmpSal();
		
		out.println("<html><body style='background-color:#BACD92;padding:50px;'>");
		out.println("<a href='mainView' style='border-radius: 8px; padding:7px;background-color:grey;color:white;text-decoration:none'>Back</a>");
		out.println("<center style='background-color:#CDE8E5;padding:20px;width:400px;margin:auto;'>");
		out.println("<h1 style='color:green;'>Update Employee</h1><form action='update' method='post'>");
		
		out.println("<table><tr><td><label style='color:red;'>Employee Number :</label></td>");
		out.println("<td style='padding:5px;'><input type='text' readonly name='emp_no' value='"+empNo+"' style='color:red;height:25px;'></td></tr>");
		
		out.println("<tr><td><label style='color:blue;'>New Employee Name :</label></td>");
		out.println("<td style='padding:5px;'><input type='text' name='emp_name' value='"+empName+"' style='height:25px;'></td></tr>");
		
		out.println("<tr><td><label style='color:blue;'>New Employee Salary :</label></td>");
		out.println("<td style='padding:5px;'><input type='text' name='emp_sal' value='"+empSal+"' style='height:25px;'></td></tr>");
		
		out.println("</table><br><input type='submit' value='Update' style='background-color:rgb(220,220,0);color:white;'>");
		out.println("</form></center></body></html>");
				
	}	

}
