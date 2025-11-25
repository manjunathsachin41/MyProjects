package com.examples.executerThread;

public class Employee {
	
	private int empId;
	
	private String empName;
	
	private double basicSalaryPerDay;
	
	private int noOfWorkingDays;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getBasicSalaryPerDay() {
		return basicSalaryPerDay;
	}

	public void setBasicSalaryPerDay(double basicSalaryPerDay) {
		this.basicSalaryPerDay = basicSalaryPerDay;
	}

	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}

	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}

	public Employee(int empId, String empName, double basicSalaryPerDay, int noOfWorkingDays) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.basicSalaryPerDay = basicSalaryPerDay;
		this.noOfWorkingDays = noOfWorkingDays;
	}
	
}
