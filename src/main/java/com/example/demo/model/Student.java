package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")

public class Student extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_id;
	private String college;
	private String courses;

	public Student() {
		super();
	}

	public Student(int s_id, String college, String courses) {
		super();
		this.s_id = s_id;
		this.college = college;
		this.courses = courses;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", college=" + college + ", courses=" + courses + "]";
	}

}
