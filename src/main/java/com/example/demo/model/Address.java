package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(schema = "CUST_UPLOAD", name = "addres_seq", allocationSize = 1)
	private int id;

	@NotBlank(message = "The country is required.")
	private String country;

	@NotBlank(message = "The city is required.")
	private String city;

	@NotBlank(message = "The Zip code is required.")
	private String zipCode;

	@NotBlank(message = "The street name is required.")
	private String street;

	@NotBlank(message = "State should be mandatory")
	private String state;


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressDto [country=" + country + ", city=" + city + ", zipCode=" + zipCode + ", street=" + street
				+ ", state=" + state + "]";
	}

}
