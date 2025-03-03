package com.ravi.basic.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ravi.basic.dao.UserDao;
import com.ravi.basic.dao.UserDaoImp;
import com.ravi.basic.model.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class AddUserController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		
		String fullName = req.getParameter("full_name");
		String userName = req.getParameter("user_name");
		String userpass = req.getParameter("user_pass");
	
		User user = new User();
		user.setFullName(fullName);
		user.setUserName(userName);
		user.setUserPass(userpass);
		
		try {
			UserDao userDao = new UserDaoImp();
			String msg = userDao.addUser(user);
			sc.setAttribute("username", msg);
			res.sendRedirect("mainController");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			}
			
		}
}
