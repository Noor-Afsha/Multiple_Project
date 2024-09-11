package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CU_Account_model")
public class AccModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "cu_account_model_SEQ", allocationSize = 1)
	private int id;
	private String accountNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "AccModel [id=" + id + ", accountNumber=" + accountNumber + "]";
	}

}
