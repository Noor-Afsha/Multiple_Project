package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sav_cust_personal")
public class CustomerPersonalView {

	@Id
	private String customerNo;

	private String firstName;

	private String mobileNumber;

	private String customerName1;

	private String customerType;

	private String pNationalId;

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName1() {
		return customerName1;
	}

	public void setCustomerName1(String customerName1) {
		this.customerName1 = customerName1;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getpNationalId() {
		return pNationalId;
	}

	public void setpNationalId(String pNationalId) {
		this.pNationalId = pNationalId;
	}

	@Override
	public String toString() {
		return "CustomerPersonalView [customerNo=" + customerNo + ", firstName=" + firstName + ", mobileNumber="
				+ mobileNumber + ", customerName1=" + customerName1 + ", customerType=" + customerType
				+ ", pNationalId=" + pNationalId + "]";
	}

}
