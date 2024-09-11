package com.Wecoodee.CustomerAppliaction.Dto;

import com.Wecoodee.CustomerAppliaction.model.CaDetails;

public class ApiResponse {

	private CaDetails caDetails;
	private String userRemarks;
	private boolean confirmWarning;

	public CaDetails getCaDetails() {
		return caDetails;
	}

	public void setCaDetails(CaDetails caDetails) {
		this.caDetails = caDetails;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	public boolean isConfirmWarning() {
		return confirmWarning;
	}

	public void setConfirmWarning(boolean confirmWarning) {
		this.confirmWarning = confirmWarning;
	}

	@Override
	public String toString() {
		return "ApiResponse [caDetails=" + caDetails + ", userRemarks=" + userRemarks + ", confirmWarning="
				+ confirmWarning + "]";
	}

}
