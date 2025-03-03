package com.ravi.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ravi.basic.dao.UserDaoImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/valid")
public class ValidUserController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		
		String userName = req.getParameter("user_name");
		String userPass = req.getParameter("user_pass");
		
		try {
			UserDaoImp userDao = new UserDaoImp();
			ResultSet resultSet = userDao.valid(userName);
			
			if(resultSet.next() == true && userPass.equals(resultSet.getString(3)))
			{
				sc.setAttribute("username", resultSet.getString(1));
				res.sendRedirect("mainController");
				
			}else {
				res.sendRedirect("errorView");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
