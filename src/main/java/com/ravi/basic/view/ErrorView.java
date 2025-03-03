package com.ravi.basic.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/errorView")
public class ErrorView extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body style='background-color:#BACD92;padding:50px;'>");
		out.println("<a href='index.html' style='border-radius: 8px; padding:7px;background-color:grey;color:white;text-decoration:none'>Back</a>");
		out.println("<center style='background-color:#CDE8E5;padding:20px;width:400px;margin:auto;'>");
		out.println("<h1 style='color:red;'>Please Enter Correct Delail...</h1><form action='update' method='post'>");
		out.println("</center></body></html>");
	}	
}
