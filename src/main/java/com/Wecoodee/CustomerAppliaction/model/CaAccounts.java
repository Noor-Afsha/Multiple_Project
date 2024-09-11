package com.Wecoodee.CustomerAppliaction.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sfo_ca_accounts")

public class CaAccounts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accId;
	private String applicationNumber;
	private String customerNo;
	private String accountClass;
	private String accountCcy;
	private String accountBranch;
	private String accountNumber;
	private String accountName;
	private Date accountOpenedDate;
	private Boolean acStatNoDebit;
	private Boolean acStatNoCredit;
	private Boolean acStatFrozen;
	private Boolean acStatPostingAllowed;
	private Boolean acStatAutoStatusChange;
	private String drRepGl;
	private String crRepGl;
	private String accountMessage;

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getAccountOpenedDate() {
		return accountOpenedDate;
	}

	public void setAccountOpenedDate(Date accountOpenedDate) {
		this.accountOpenedDate = accountOpenedDate;
	}

	public Boolean getAcStatNoDebit() {
		return acStatNoDebit;
	}

	public void setAcStatNoDebit(Boolean acStatNoDebit) {
		this.acStatNoDebit = acStatNoDebit;
	}

	public Boolean getAcStatNoCredit() {
		return acStatNoCredit;
	}

	public void setAcStatNoCredit(Boolean acStatNoCredit) {
		this.acStatNoCredit = acStatNoCredit;
	}

	public Boolean getAcStatFrozen() {
		return acStatFrozen;
	}

	public void setAcStatFrozen(Boolean acStatFrozen) {
		this.acStatFrozen = acStatFrozen;
	}

	public Boolean getAcStatPostingAllowed() {
		return acStatPostingAllowed;
	}

	public void setAcStatPostingAllowed(Boolean acStatPostingAllowed) {
		this.acStatPostingAllowed = acStatPostingAllowed;
	}

	public Boolean getAcStatAutoStatusChange() {
		return acStatAutoStatusChange;
	}

	public void setAcStatAutoStatusChange(Boolean acStatAutoStatusChange) {
		this.acStatAutoStatusChange = acStatAutoStatusChange;
	}

	public String getDrRepGl() {
		return drRepGl;
	}

	public void setDrRepGl(String drRepGl) {
		this.drRepGl = drRepGl;
	}

	public String getCrRepGl() {
		return crRepGl;
	}

	public void setCrRepGl(String crRepGl) {
		this.crRepGl = crRepGl;
	}

	public String getAccountMessage() {
		return accountMessage;
	}

	public void setAccountMessage(String accountMessage) {
		this.accountMessage = accountMessage;
	}

	@Override
	public String toString() {
		return "CaAccounts [accId=" + accId + ", applicationNumber=" + applicationNumber + ", customerNo=" + customerNo
				+ ", accountClass=" + accountClass + ", accountCcy=" + accountCcy + ", accountBranch=" + accountBranch
				+ ", accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountOpenedDate="
				+ accountOpenedDate + ", acStatNoDebit=" + acStatNoDebit + ", acStatNoCredit=" + acStatNoCredit
				+ ", acStatFrozen=" + acStatFrozen + ", acStatPostingAllowed=" + acStatPostingAllowed
				+ ", acStatAutoStatusChange=" + acStatAutoStatusChange + ", drRepGl=" + drRepGl + ", crRepGl=" + crRepGl
				+ ", accountMessage=" + accountMessage + "]";
	}

}
