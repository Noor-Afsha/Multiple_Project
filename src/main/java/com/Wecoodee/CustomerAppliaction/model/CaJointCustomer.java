package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SFO_CA_JOINT_CUSTOMER")

public class CaJointCustomer {

	@Id
	private String custId;
	private String customerNumber;
	private String applicationNumber;
	private String customerType;
	private String customerBranch;
	private String customerCategory;
	private String jointHolderType;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerBranch() {
		return customerBranch;
	}

	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getJointHolderType() {
		return jointHolderType;
	}

	public void setJointHolderType(String jointHolderType) {
		this.jointHolderType = jointHolderType;
	}

	@Override
	public String toString() {
		return "CaJointCustomer [custId=" + custId + ", customerNumber=" + customerNumber + ", applicationNumber="
				+ applicationNumber + ", customerType=" + customerType + ", customerBranch=" + customerBranch
				+ ", customerCategory=" + customerCategory + ", jointHolderType=" + jointHolderType + "]";
	}
}
