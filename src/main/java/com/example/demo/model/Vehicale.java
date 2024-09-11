package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICALE")
public class Vehicale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicaleId;
	private String name;

	public int getVehicaleId() {
		return vehicaleId;
	}

	public void setVehicaleId(int vehicaleId) {
		this.vehicaleId = vehicaleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicale [vehicaleId=" + vehicaleId + ", name=" + name + "]";
	}

}
