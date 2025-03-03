package com.ravi.basic.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
	private MyConnection() {
		
	}
	private static Connection connection;
	public static Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		if(connection==null) {
			Properties prop = new Properties();

			prop.load(new FileReader("MyConnection.properties"));
			String driverName = prop.getProperty("DriverName");
			String url = prop.getProperty("URL");
			String userName = prop.getProperty("UserName");
			String password = prop.getProperty("Password");
			Class.forName(driverName);
			System.out.println("*****connecting****");
			connection = DriverManager.getConnection(url,userName,password);
			System.out.println("*****connected****");
			return connection;
		}
		return connection;
	}
}
