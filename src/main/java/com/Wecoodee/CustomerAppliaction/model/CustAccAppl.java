package com.Wecoodee.CustomerAppliaction.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sfo_cust_acc_appl")
public class CustAccAppl {

	@Id
	private String applicationNumber;
	@Column(length = 10)
	private String userRefNumber;
	private Date applicationDate;
	private String customerNumber;
	private String customerType;
	private String customerBranch;
	private String customerCategory;
	private String accountType;
	private String accountClass;
	private String accountCcy;
	private String accountBranch;
	private String accountNumber;
	private String kycStatus;
	private String module;
	private String modeOfOperation;
	private String applicationType;
	private String externalRefNumber;
	private Boolean otpValidated;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationNumber", referencedColumnName = "applicationNumber")
	private List<CaDetails> caDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationNumber", referencedColumnName = "applicationNumber")
	private List<CaAccounts> caAccounts;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationNumber", referencedColumnName = "applicationNumber")
	private List<CaJointCustomer> caJointCustomer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationNumber", referencedColumnName = "applicationNumber")
	private List<CaApplErrors> caApplError;

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public  void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getUserRefNumber() {
		return userRefNumber;
	}

	public void setUserRefNumber(String userRefNumber) {
		this.userRefNumber = userRefNumber;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountClass() {
		return accountClass;
	}

	public void setAccountClass(String accountClass) {
		this.accountClass = accountClass;
	}

	public String getAccountCcy() {
		return accountCcy;
	}

	public void setAccountCcy(String accountCcy) {
		this.accountCcy = accountCcy;
	}

	public String getAccountBranch() {
		return accountBranch;
	}

	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getModeOfOperation() {
		return modeOfOperation;
	}

	public void setModeOfOperation(String modeOfOperation) {
		this.modeOfOperation = modeOfOperation;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getExternalRefNumber() {
		return externalRefNumber;
	}

	public void setExternalRefNumber(String externalRefNumber) {
		this.externalRefNumber = externalRefNumber;
	}

	public Boolean getOtpValidated() {
		return otpValidated;
	}

	public void setOtpValidated(Boolean otpValidated) {
		this.otpValidated = otpValidated;
	}

	public List<CaDetails> getCaDetails() {
		return caDetails;
	}

	public void setCaDetails(List<CaDetails> caDetails) {
		this.caDetails = caDetails;
	}

	public List<CaAccounts> getCaAccounts() {
		return caAccounts;
	}

	public void setCaAccounts(List<CaAccounts> caAccounts) {
		this.caAccounts = caAccounts;
	}

	public List<CaJointCustomer> getCaJointCustomer() {
		return caJointCustomer;
	}

	public void setCaJointCustomer(List<CaJointCustomer> caJointCustomer) {
		this.caJointCustomer = caJointCustomer;
	}

	public List<CaApplErrors> getCaApplError() {
		return caApplError;
	}

	public void setCaApplError(List<CaApplErrors> caApplError) {
		this.caApplError = caApplError;
	}

	@Override
	public String toString() {
		return "CustAccAppl [applicationNumber=" + applicationNumber + ", userRefNumber=" + userRefNumber
				+ ", applicationDate=" + applicationDate + ", customerNumber=" + customerNumber + ", customerType="
				+ customerType + ", customerBranch=" + customerBranch + ", customerCategory=" + customerCategory
				+ ", accountType=" + accountType + ", accountClass=" + accountClass + ", accountCcy=" + accountCcy
				+ ", accountBranch=" + accountBranch + ", accountNumber=" + accountNumber + ", kycStatus=" + kycStatus
				+ ", module=" + module + ", modeOfOperation=" + modeOfOperation + ", applicationType=" + applicationType
				+ ", externalRefNumber=" + externalRefNumber + ", otpValidated=" + otpValidated + ", caDetails="
				+ caDetails + ", caAccounts=" + caAccounts + ", caJointCustomer=" + caJointCustomer + ", caApplError="
				+ caApplError + "]";
	}

}
