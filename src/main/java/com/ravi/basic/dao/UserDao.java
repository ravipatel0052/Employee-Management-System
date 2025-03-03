package com.ravi.basic.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ravi.basic.model.User;

public interface UserDao {
	String addUser(User user) throws IOException,SQLException;
	ResultSet valid(String userName) throws IOException,SQLException;
}
