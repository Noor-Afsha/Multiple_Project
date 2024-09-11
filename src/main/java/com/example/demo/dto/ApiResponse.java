package com.example.demo.dto;

public class ApiResponse {

	private int status;
	private String message;

	public ApiResponse(ResponseStatusCode status, String message) {
		super();
		this.status = status.getStatus();
		this.message = message;
	}

	public ApiResponse() {
		super();
	}

	public static ApiResponse success(String message) {
		return new ApiResponse(ResponseStatusCode.success, message);
	}

	public static ApiResponse failed(String message) {
		return new ApiResponse(ResponseStatusCode.failed, message);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
		return "ApiResponse [status=" + status + ", message=" + message + "]";
	}

}
