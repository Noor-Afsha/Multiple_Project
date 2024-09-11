package com.example.demo.dto;

public enum ResponseStatusCode {

	success(1),failed(0);
	private int status;

	 ResponseStatusCode(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}	
	
}
