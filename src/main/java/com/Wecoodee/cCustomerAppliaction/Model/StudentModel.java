package com.Wecoodee.cCustomerAppliaction.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_MODEL")
public class StudentModel {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "ROLL_NUMBER", length = 50)
	private int rollNumber;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "ADDRESS", length = 50)
	private String address;

	@Column(name = "PERCETAGE", length = 50)
	private double percentage;

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "StudentModel [rollNumber=" + rollNumber + ", name=" + name + ", address=" + address + ", percentage="
				+ percentage + "]";
	}

}
