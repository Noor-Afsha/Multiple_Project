package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "SFO_POLICE")
public class Police {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(schema = "CUST_UPLOAD", name = "sfo_police_seq", allocationSize = 1)
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Police [id=" + id + ", name=" + name + "]";
	}

}
