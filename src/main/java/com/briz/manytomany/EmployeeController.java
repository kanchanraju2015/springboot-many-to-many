package com.briz.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
@Autowired
EmployeeRepository erepo;
@Autowired
ProjectRepository prepo;
@RequestMapping("/")
public String hello()
{
	return "this is many to many";
}
@RequestMapping("/save")
public String saved()
{
	Employee e=new Employee();
	Employee e1=new Employee();
	
	e.setEmpname("chandrika");
	e1.setEmpname("sunaina");
	
	Project p=new Project();
	Project p1=new Project();
	
	p.setProjname("dot net project");
	p1.setProjname("dbase project");
	// employee and project initialized
	List<Employee> elist=new ArrayList<>();
	elist.add(e);
	elist.add(e1);
	// adding employees to the list  
	p.setEmployee(elist);// setting employee to the project
	p1.setEmployee(elist);
	// one project has many employees
	
	List<Project> plist=new ArrayList<Project>();
	
	plist.add(p);
	plist.add(p1);
	
    e.setProject(plist);
    e1.setProject(plist);
	
	erepo.save(e);
	
	return "data saved";
}
@RequestMapping("/all")
public List<Employee> alldata()
{
	return erepo.findAll();
}
@RequestMapping("/alldata")
public List<Employee> all()
{
	return erepo.findAll();
}
@RequestMapping("/{id}")
public Employee getemp(@PathVariable int id)
{
	return erepo.findById(id);
}
@RequestMapping("/project")
public List<Project> bypro()
{
	return prepo.findAll();
}
@RequestMapping("/project/{projname}")
public List<Project> byproj(@PathVariable String projname)
{
	return prepo.findByProjname(projname);
}
}
