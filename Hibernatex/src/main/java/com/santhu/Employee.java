package com.santhu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id	
@Column(name="EmpId")
private int empid;
@Column
private String name;
@Column
private double sal;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
}
