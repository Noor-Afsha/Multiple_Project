package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR")
public class Doctor extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doc_id;
	private String position;
	private String specalist;

	public Doctor() {
		super();
	}

	public Doctor(int doc_id, String position, String specalist) {
		super();
		this.doc_id = doc_id;
		this.position = position;
		this.specalist = specalist;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSpecalist() {
		return specalist;
	}

	public void setSpecalist(String specalist) {
		this.specalist = specalist;
	}

	@Override
	public String toString() {
		return "Doctor [doc_id=" + doc_id + ", position=" + position + ", specalist=" + specalist + "]";
	}

}
