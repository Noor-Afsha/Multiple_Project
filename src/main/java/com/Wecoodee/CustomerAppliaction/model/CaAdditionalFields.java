package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CA_ADDITIONAL_FIELDS")
public class CaAdditionalFields {
	@Id

	private String custId;
	private Boolean referralCustomer;
	private String referrerCifNo;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Boolean getReferralCustomer() {
		return referralCustomer;
	}

	public void setReferralCustomer(Boolean referralCustomer) {
		this.referralCustomer = referralCustomer;
	}

	public String getReferrerCifNo() {
		return referrerCifNo;
	}

	public void setReferrerCifNo(String referrerCifNo) {
		this.referrerCifNo = referrerCifNo;
	}

	@Override
	public String toString() {
		return "CaAdditionalFields [custId=" + custId + ", referralCustomer=" + referralCustomer + ", referrerCifNo="
				+ referrerCifNo + "]";
	}

}
