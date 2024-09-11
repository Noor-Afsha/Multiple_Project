package com.Wecoodee.CustomerAppliaction.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CA_DOCUMENTS")
public class CaDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long documentId;

	private String documentCategory;

	private String documentType;

	private String documentData;

	private String fileName;

	private String custId;

	private Boolean mandatory;

	private String idNumber;

	private String idIssuedBy;

	private Date idIssueDate;

	private Boolean kycVerified;

	private Boolean documentUploaded;

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentData() {
		return documentData;
	}

	public void setDocumentData(String documentData) {
		this.documentData = documentData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdIssuedBy() {
		return idIssuedBy;
	}

	public void setIdIssuedBy(String idIssuedBy) {
		this.idIssuedBy = idIssuedBy;
	}

	public Date getIdIssueDate() {
		return idIssueDate;
	}

	public void setIdIssueDate(Date idIssueDate) {
		this.idIssueDate = idIssueDate;
	}

	public Boolean getKycVerified() {
		return kycVerified;
	}

	public void setKycVerified(Boolean kycVerified) {
		this.kycVerified = kycVerified;
	}

	public Boolean getDocumentUploaded() {
		return documentUploaded;
	}

	public void setDocumentUploaded(Boolean documentUploaded) {
		this.documentUploaded = documentUploaded;
	}

	@Override
	public String toString() {
		return "CaDocuments [documentId=" + documentId + ", documentCategory=" + documentCategory + ", documentType="
				+ documentType + ", documentData=" + documentData + ", fileName=" + fileName + ", custId=" + custId
				+ ", mandatory=" + mandatory + ", idNumber=" + idNumber + ", idIssuedBy=" + idIssuedBy
				+ ", idIssueDate=" + idIssueDate + ", kycVerified=" + kycVerified + ", documentUploaded="
				+ documentUploaded + "]";
	}

}
