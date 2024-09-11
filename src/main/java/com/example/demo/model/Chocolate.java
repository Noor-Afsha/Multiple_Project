package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHOCOLATE")
public class Chocolate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chocoId;
	private double price;
	private String brand;
	private String chocolateName;

	

	public int getChocoId() {
		return chocoId;
	}

	public void setChocoId(int chocoId) {
		this.chocoId = chocoId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getChocolateName() {
		return chocolateName;
	}

	public void setChocolateName(String chocolateName) {
		this.chocolateName = chocolateName;
	}

	@Override
	public String toString() {
		return "Chocolate [chocoId=" + chocoId + ", price=" + price + ", brand=" + brand + ", chocolateName="
				+ chocolateName + "]";
	}

}
