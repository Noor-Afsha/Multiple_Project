package com.Wecoodee.cCustomerAppliaction.dto;

public class ApiResponse {

	private String status;
	private String codeStatus;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodeStatus() {
		return codeStatus;
	}

	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", codeStatus=" + codeStatus + ", message=" + message + "]";
	}

}
