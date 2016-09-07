package com.hibernate.relations.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="emp")
public class Employee {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column
private Long emp_id;
@Column
private String first_name;
@Column
private String last_name;
@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name="emp_meeting" ,joinColumns={@JoinColumn(name="emp_id")},inverseJoinColumns={@JoinColumn(name="meeting_id")}  )
private Set<Meeting> meetings=new HashSet<Meeting>();

public Employee() {
}
public Employee(String first_name, String last_name) {
	this.first_name = first_name;
	this.last_name = last_name;
}
public Long getEmp_id() {
	return emp_id;
}
public void setEmp_id(Long emp_id) {
	this.emp_id = emp_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public Set<Meeting> getMeetings() {
	return meetings;
}
public void setMeetings(Set<Meeting> meetings) {
	this.meetings = meetings;
}

}
