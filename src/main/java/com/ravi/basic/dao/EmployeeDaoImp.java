package com.ravi.basic.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ravi.basic.connection.MyConnection;
import com.ravi.basic.model.Employee;

public class EmployeeDaoImp implements EmployeeDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;
	
	public EmployeeDaoImp() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		connection = MyConnection.getConnection();
	}

	@Override
	public String addEmployee(Employee employee) throws IOException, SQLException {
		// TODO Auto-generated method stub
		sql="insert into empl value(?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1,employee.getEmpNo());
		preparedStatement.setString(2,employee.getEmpName());
		preparedStatement.setDouble(3,employee.getEmpSal());
		Integer count = preparedStatement.executeUpdate();
		
		return count+" Record Added...";
	}
	
	@Override
	public List<Employee> AllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from empl";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		List <Employee> list=new ArrayList<>();
		while(resultSet.next()) {
			
            Employee employee = new Employee();
            employee.setEmpNo(resultSet.getInt(1));
            employee.setEmpName(resultSet.getString(2));
            employee.setEmpSal(resultSet.getDouble(3));
            list.add(employee);
            
		}
		return list;
	}
	
	@Override
	public String deleteEmployee(Integer empNo) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from empl where empNo = ?";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1,empNo);
		Integer count = preparedStatement.executeUpdate();
		
		return count+" Record deleted...";
	}
	
	@Override
	public String updateEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		
		sql="update empl set empName = ?,empSal = ? where empNo= ?";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,employee.getEmpName());
		preparedStatement.setDouble(2,employee.getEmpSal());
		preparedStatement.setInt(3,employee.getEmpNo());
		Integer count = preparedStatement.executeUpdate();
		
		return count+" Record update...";
		
	}

	@Override
	public Employee findRecord(Integer empNo) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from empl where empno = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, empNo);
		resultSet = preparedStatement.executeQuery();
		Employee employee= new Employee();
		if(resultSet.next()) {
			employee.setEmpNo(Integer.parseInt(resultSet.getString(1)));
			employee.setEmpName(resultSet.getString(2));
			employee.setEmpSal(Double.parseDouble(resultSet.getString(3)));
		}
		return employee;
	}

}
