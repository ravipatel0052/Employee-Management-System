package com.ravi.basic.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ravi.basic.connection.MyConnection;
import com.ravi.basic.model.User;

import jakarta.servlet.RequestDispatcher;

public class UserDaoImp implements UserDao{

	private Connection connection;
	private PreparedStatement preparedStatement;
	private String sql;
	
	public UserDaoImp() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		connection = MyConnection.getConnection();
	}
	
	@Override
	public String addUser(User user) throws IOException, SQLException {
		sql="insert into login value(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,user.getFullName());
		preparedStatement.setString(2,user.getUserName());
		preparedStatement.setString(3,user.getUserPass());
		preparedStatement.setString(4,"");
		preparedStatement.executeUpdate();
		
		return user.getFullName();
	}

	@Override
	public ResultSet valid(String userName) throws IOException, SQLException {
		// TODO Auto-generated method stub
		sql="select * from login where username = ?";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,userName);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		return resultSet;
	}

}
