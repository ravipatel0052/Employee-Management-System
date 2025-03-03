package com.ravi.basic.model;

public class Employee {
	private Integer empNo;
	private String empName;
	private Double empSal;
	
	public void setEmpNo(Integer empNo)
	{
		this.empNo=empNo;
	}
	
	public Integer getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	
}
