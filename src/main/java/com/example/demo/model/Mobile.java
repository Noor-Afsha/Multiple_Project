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

	private int mobId;
	private String name;

	public int getMobId() {
		return mobId;
	}

	public void setMobId(int mobId) {
		this.mobId = mobId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Mobile [mobId=" + mobId + ", name=" + name + "]";
	}

}
