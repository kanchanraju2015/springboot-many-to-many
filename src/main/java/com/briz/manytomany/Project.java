package com.briz.manytomany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name="project")
public class Project 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String projname;
@JsonBackReference
@ManyToMany(cascade=CascadeType.ALL,mappedBy="project")
List<Employee> employee;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProjname() {
	return projname;
}
public void setProjname(String projname) {
	this.projname = projname;
}
public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}

}
