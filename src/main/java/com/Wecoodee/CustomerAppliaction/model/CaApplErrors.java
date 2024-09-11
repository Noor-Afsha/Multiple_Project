package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SFO_CA_APPL_ERRORS")

public class CaApplErrors {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String requestId;
	private String applicationNumber;
	private String applicationType;
	private String errorCode;
	private String errorMessage;
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CaApplErrors [id=" + id + ", requestId=" + requestId + ", applicationNumber=" + applicationNumber
				+ ", applicationType=" + applicationType + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", type=" + type + "]";
	}
}
