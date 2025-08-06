package com.many.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int pid;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Empl> emps;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Empl> getEmps() {
		return emps;
	}

	public void setEmps(List<Empl> emps) {
		this.emps = emps;
	}

	public Project(int pid, String projectName, List<Empl> emps) {
		super();
		this.pid = pid;
		this.projectName = projectName;
		this.emps = emps;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
