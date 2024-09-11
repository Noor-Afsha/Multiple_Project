package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int perid;
	private String vehicale;
	
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
	public String getVehicale() {
		return vehicale;
	}
	public void setVehicale(String vehicale) {
		this.vehicale = vehicale;
	}
	@Override
	public String toString() {
		return "PersonDetails [perid=" + perid + ", vehicale=" + vehicale + "]";
	}

	

}