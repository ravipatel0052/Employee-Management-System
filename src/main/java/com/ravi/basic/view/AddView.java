package com.ravi.basic.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addView")
public class AddView extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<html><body style='background-color:#BACD92;padding:50px;'>");
		out.println("<a href='mainView' style='border-radius: 8px; padding:7px;background-color:grey;color:white;text-decoration:none'>Back</a>");
		out.println("<center style='background-color:#CDE8E5;padding:20px;width:400px;margin:auto;'>");
		out.println("<h1 style='color:green;'>Add Employee</h1><form action='add' method='post'>");
		
		out.println("<table><tr><td><label style='color:blue;'>Employee Number :</label></td>");
		out.println("<td style='padding:5px;'><input type='text' placeholder='Enter Employee Number' name='emp_no' style='height:25px;'></td></tr>");
		
		out.println("<tr><td><label style='color:blue;'>Employee Name :</label></td>");
		out.println("<td style='padding:5px;'><input type='text' placeholder='Enter Employee Name' name='emp_name' style='height:25px;'></td></tr>");
		
		out.println("<tr><td><label style='color:blue;'>Employee Salary :</label></td>");
		out.println("<td style='padding:5px;'><input type='text' placeholder='Enter Employee Salary' name='emp_sal' style='height:25px;'></td></tr>");
		
		out.println("</table><br><input type='submit' value='Add Record' style='background-color:green;color:white;'>");
		out.println("</form></center></body></html>");
				
	}	

}
