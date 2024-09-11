package com.Wecoodee.CustomerAppliaction.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CA_DETAILS_PERONAL")
public class CaDetailsPersonal {

	@Id
	private String custId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String occupation;
	private String position;
	private String employer;
	private Double averageMonthlyIncome;
	private Double averageAnnualIncome;
	private String motherFullName;
	private String employmentStatus;
	private String maritalStatus;
	private String relationship;
	private String guardian;
	private Boolean minor;
	private Boolean powerOfAttorney;
	private String holderName;
	private String address;
	private String nationality;
	private String telephoneIsdCode;
	private String telephoneNumber;
	private String country;
	private String tinNo;
	private String passportNo;
	private Date pptIssDate;
	private Date pptExpDate;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
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

	public String getMotherFullName() {
		return motherFullName;
	}

	public void setMotherFullName(String motherFullName) {
		this.motherFullName = motherFullName;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public Boolean getMinor() {
		return minor;
	}

	public void setMinor(Boolean minor) {
		this.minor = minor;
	}

	public Boolean getPowerOfAttorney() {
		return powerOfAttorney;
	}

	public void setPowerOfAttorney(Boolean powerOfAttorney) {
		this.powerOfAttorney = powerOfAttorney;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTelephoneIsdCode() {
		return telephoneIsdCode;
	}

	public void setTelephoneIsdCode(String telephoneIsdCode) {
		this.telephoneIsdCode = telephoneIsdCode;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getPptIssDate() {
		return pptIssDate;
	}

	public void setPptIssDate(Date pptIssDate) {
		this.pptIssDate = pptIssDate;
	}

	public Date getPptExpDate() {
		return pptExpDate;
	}

	public void setPptExpDate(Date pptExpDate) {
		this.pptExpDate = pptExpDate;
	}

	@Override
	public String toString() {
		return "CaDetailsPersonal [custId=" + custId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", occupation="
				+ occupation + ", position=" + position + ", employer=" + employer + ", averageMonthlyIncome="
				+ averageMonthlyIncome + ", averageAnnualIncome=" + averageAnnualIncome + ", motherFullName="
				+ motherFullName + ", employmentStatus=" + employmentStatus + ", maritalStatus=" + maritalStatus
				+ ", relationship=" + relationship + ", guardian=" + guardian + ", minor=" + minor
				+ ", powerOfAttorney=" + powerOfAttorney + ", holderName=" + holderName + ", address=" + address
				+ ", nationality=" + nationality + ", telephoneIsdCode=" + telephoneIsdCode + ", telephoneNumber="
				+ telephoneNumber + ", country=" + country + ", tinNo=" + tinNo + ", passportNo=" + passportNo
				+ ", pptIssDate=" + pptIssDate + ", pptExpDate=" + pptExpDate + "]";
	}

}
