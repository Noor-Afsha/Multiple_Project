package com.Wecoodee.CustomerAppliaction.Dto;

import com.Wecoodee.CustomerAppliaction.model.CustAccAppl;

public class CreateCustomerAccountApplicationDTO {
	private CustAccAppl custAccAppl;
	private String userRemarks;
	private boolean confirmWarning;

	public CustAccAppl getCustAccAppl() {
		return custAccAppl;
	}

	public void setCustAccAppl(CustAccAppl custAccAppl) {
		this.custAccAppl = custAccAppl;
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
		return "CreateCustomerAccountApplicationDTO [custAccAppl=" + custAccAppl + ", userRemarks=" + userRemarks
				+ ", confirmWarning=" + confirmWarning + "]";
	}

}
