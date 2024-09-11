package com.example.demo.studentDto;

public class ApiResponseDto {
	private int statusCode;
	private String status;
	private String message;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponseDto [statusCode=" + statusCode + ", status=" + status + ", message=" + message + "]";
	}

}
