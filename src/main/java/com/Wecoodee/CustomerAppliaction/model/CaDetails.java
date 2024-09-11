package com.Wecoodee.CustomerAppliaction.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CaDetails {

	@Id
	private String custId;
	private String customerName;
	private String agentName;
	private String city;
	private String subCity;
	private String kebele;
	private String hNo;
	private String mobCountryCode;
	private String mobileNo;
	private String telCountryCode;
	private String offTel;
	private String faxCountryCode;
	private String faxNo;
	private String poBox;
	private String email;
	private String idType;
	private String issuedBy;
	private String nationality;
	private String applicationNumber;
	private String customerNumber;
	private String customerType;
	private String customerCategory;
	private String customerBranch;
	private Boolean primary;
	private String uidName;
	private String uidValue;
	private String media;
	private String commMode;
	private String location;
	private Date issuedDate;
	private String passbookNumber;
	private String residenceStatus;
	private String country;
	private String customerRiskRating;
	private String nationalId;
	private String jointHolderType;
	private String shortName;
	private String originSource;
	private String kycStatus;
	private String extCustId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	private CaDetailsPersonal caDetailsPersonals;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	private CaDetailsCorporate caDetailsCorporates;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	private CaAdditionalFields caAdditionalFields;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	private List<CaImages> caImages;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	List<CaDocuments> caDocuments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	List<CaOperationInstruction> caOperationInstructions;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubCity() {
		return subCity;
	}

	public void setSubCity(String subCity) {
		this.subCity = subCity;
	}

	public String getKebele() {
		return kebele;
	}

	public void setKebele(String kebele) {
		this.kebele = kebele;
	}

	public String gethNo() {
		return hNo;
	}

	public void sethNo(String hNo) {
		this.hNo = hNo;
	}

	public String getMobCountryCode() {
		return mobCountryCode;
	}

	public void setMobCountryCode(String mobCountryCode) {
		this.mobCountryCode = mobCountryCode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTelCountryCode() {
		return telCountryCode;
	}

	public void setTelCountryCode(String telCountryCode) {
		this.telCountryCode = telCountryCode;
	}

	public String getOffTel() {
		return offTel;
	}

	public void setOffTel(String offTel) {
		this.offTel = offTel;
	}

	public String getFaxCountryCode() {
		return faxCountryCode;
	}

	public void setFaxCountryCode(String faxCountryCode) {
		this.faxCountryCode = faxCountryCode;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
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

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getCustomerBranch() {
		return customerBranch;
	}

	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public String getUidName() {
		return uidName;
	}

	public void setUidName(String uidName) {
		this.uidName = uidName;
	}

	public String getUidValue() {
		return uidValue;
	}

	public void setUidValue(String uidValue) {
		this.uidValue = uidValue;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getCommMode() {
		return commMode;
	}

	public void setCommMode(String commMode) {
		this.commMode = commMode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getPassbookNumber() {
		return passbookNumber;
	}

	public void setPassbookNumber(String passbookNumber) {
		this.passbookNumber = passbookNumber;
	}

	public String getResidenceStatus() {
		return residenceStatus;
	}

	public void setResidenceStatus(String residenceStatus) {
		this.residenceStatus = residenceStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCustomerRiskRating() {
		return customerRiskRating;
	}

	public void setCustomerRiskRating(String customerRiskRating) {
		this.customerRiskRating = customerRiskRating;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getJointHolderType() {
		return jointHolderType;
	}

	public void setJointHolderType(String jointHolderType) {
		this.jointHolderType = jointHolderType;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getOriginSource() {
		return originSource;
	}

	public void setOriginSource(String originSource) {
		this.originSource = originSource;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getExtCustId() {
		return extCustId;
	}

	public void setExtCustId(String extCustId) {
		this.extCustId = extCustId;
	}

	public CaDetailsPersonal getCaDetailsPersonals() {
		return caDetailsPersonals;
	}

	public void setCaDetailsPersonals(CaDetailsPersonal caDetailsPersonals) {
		this.caDetailsPersonals = caDetailsPersonals;
	}

	public CaDetailsCorporate getCaDetailsCorporates() {
		return caDetailsCorporates;
	}

	public void setCaDetailsCorporates(CaDetailsCorporate caDetailsCorporates) {
		this.caDetailsCorporates = caDetailsCorporates;
	}

	public CaAdditionalFields getCaAdditionalFields() {
		return caAdditionalFields;
	}

	public void setCaAdditionalFields(CaAdditionalFields caAdditionalFields) {
		this.caAdditionalFields = caAdditionalFields;
	}

	public List<CaImages> getCaImages() {
		return caImages;
	}

	public void setCaImages(List<CaImages> caImages) {
		this.caImages = caImages;
	}

	public List<CaDocuments> getCaDocuments() {
		return caDocuments;
	}

	public void setCaDocuments(List<CaDocuments> caDocuments) {
		this.caDocuments = caDocuments;
	}

	public List<CaOperationInstruction> getCaOperationInstructions() {
		return caOperationInstructions;
	}

	public void setCaOperationInstructions(List<CaOperationInstruction> caOperationInstructions) {
		this.caOperationInstructions = caOperationInstructions;
	}

	@Override
	public String toString() {
		return "CaDetails [custId=" + custId + ", customerName=" + customerName + ", agentName=" + agentName + ", city="
				+ city + ", subCity=" + subCity + ", kebele=" + kebele + ", hNo=" + hNo + ", mobCountryCode="
				+ mobCountryCode + ", mobileNo=" + mobileNo + ", telCountryCode=" + telCountryCode + ", offTel="
				+ offTel + ", faxCountryCode=" + faxCountryCode + ", faxNo=" + faxNo + ", poBox=" + poBox + ", email="
				+ email + ", idType=" + idType + ", issuedBy=" + issuedBy + ", nationality=" + nationality
				+ ", applicationNumber=" + applicationNumber + ", customerNumber=" + customerNumber + ", customerType="
				+ customerType + ", customerCategory=" + customerCategory + ", customerBranch=" + customerBranch
				+ ", primary=" + primary + ", uidName=" + uidName + ", uidValue=" + uidValue + ", media=" + media
				+ ", commMode=" + commMode + ", location=" + location + ", issuedDate=" + issuedDate
				+ ", passbookNumber=" + passbookNumber + ", residenceStatus=" + residenceStatus + ", country=" + country
				+ ", customerRiskRating=" + customerRiskRating + ", nationalId=" + nationalId + ", jointHolderType="
				+ jointHolderType + ", shortName=" + shortName + ", originSource=" + originSource + ", kycStatus="
				+ kycStatus + ", extCustId=" + extCustId + ", caDetailsPersonals=" + caDetailsPersonals
				+ ", caDetailsCorporates=" + caDetailsCorporates + ", caAdditionalFields=" + caAdditionalFields
				+ ", caImages=" + caImages + ", caDocuments=" + caDocuments + ", caOperationInstructions="
				+ caOperationInstructions + "]";
	}

}
