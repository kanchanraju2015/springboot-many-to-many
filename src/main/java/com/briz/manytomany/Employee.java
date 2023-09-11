package com.briz.manytomany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity(name="employee")
public class Employee 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String empname;
@JsonManagedReference
@ManyToMany(cascade=CascadeType.ALL)

List<Project> project;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public List<Project> getProject() {
	return project;
}
public void setProject(List<Project> project) {
	this.project = project;
}

}
