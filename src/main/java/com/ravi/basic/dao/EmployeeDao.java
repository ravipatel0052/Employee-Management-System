package com.ravi.basic.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ravi.basic.model.Employee;

public interface EmployeeDao {
	String addEmployee(Employee employee) throws IOException,SQLException;
	public List<Employee> AllEmployee() throws SQLException;
	String deleteEmployee(Integer empNo) throws SQLException;
	String updateEmployee(Employee employee) throws SQLException;
	Employee findRecord(Integer empNo) throws SQLException;
}
