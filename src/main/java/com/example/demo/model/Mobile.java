package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "MOBILE")

public class Mobile {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String name;
	
	private String model;
	
	private String color;
	
	private int price;

	public Mobile() {
		super();
	}

	public Mobile(int id, String name, String model, String color, int price) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.color = color;
		this.price = price;
	}

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", model=" + model + ", color=" + color + ", price=" + price
				+ "]";
	}

}
