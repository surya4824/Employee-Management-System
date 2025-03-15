package com.hibernate.project.EmpManagementApp;

import jakarta.persistence.*;

@Entity
public class Employee {

	@Id
	int EmpID;
	
	@Column
	String EmpName;
	
	@Column
	String EmpDept;
	
	@Column
	int EmpSalary;
	
	@Column
	String JoinDate;
	
	@Column(name = "EmpNumber")
	Long EmpNumber;

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpDept() {
		return EmpDept;
	}

	public void setEmpDept(String empDept) {
		EmpDept = empDept;
	}

	public int getEmpSalary() {
		return EmpSalary;
	}

	public void setEmpSalary(int empSalary) {
		EmpSalary = empSalary;
	}

	public String getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(String joinDate) {
		JoinDate = joinDate;
	}

	public Long getEmpNumber() {
		return EmpNumber;
	}

	public void setEmpNumber(Long empNumber) {
		EmpNumber = empNumber;
	}
	
	
}
