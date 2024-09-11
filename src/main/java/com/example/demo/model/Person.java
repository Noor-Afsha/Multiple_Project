package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "perid")
	
	private PersonDetails personDetails;
	
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
	public PersonDetails getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", personDetails=" + personDetails + "]";
	}
	
	

	

}
