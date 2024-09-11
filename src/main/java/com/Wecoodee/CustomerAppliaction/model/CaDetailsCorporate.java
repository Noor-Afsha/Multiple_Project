package com.Wecoodee.CustomerAppliaction.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CA_DETAILS_CORPORATE")
public class CaDetailsCorporate {
	@Id
	private String custId;
	private Double averageMonthlyIncome;
	private Double averageAnnualIncome;
	private String registrationNo;
	private String tinNo;
	private String generalManager;
	private Date orgEstablishmentDate;
	private Double income;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Double getAverageMonthlyIncome() {
		return averageMonthlyIncome;
	}

	public void setAverageMonthlyIncome(Double averageMonthlyIncome) {
		this.averageMonthlyIncome = averageMonthlyIncome;
	}

	public Double getAverageAnnualIncome() {
		return averageAnnualIncome;
	}

	public void setAverageAnnualIncome(Double averageAnnualIncome) {
		this.averageAnnualIncome = averageAnnualIncome;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(String generalManager) {
		this.generalManager = generalManager;
	}

	public Date getOrgEstablishmentDate() {
		return orgEstablishmentDate;
	}

	public void setOrgEstablishmentDate(Date orgEstablishmentDate) {
		this.orgEstablishmentDate = orgEstablishmentDate;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "CaDetailsCorporate [custId=" + custId + ", averageMonthlyIncome=" + averageMonthlyIncome
				+ ", averageAnnualIncome=" + averageAnnualIncome + ", registrationNo=" + registrationNo + ", tinNo="
				+ tinNo + ", generalManager=" + generalManager + ", orgEstablishmentDate=" + orgEstablishmentDate
				+ ", income=" + income + "]";
	}

}
