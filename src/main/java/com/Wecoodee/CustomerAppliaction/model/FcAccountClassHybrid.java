package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_FC_ACCOUNT_CLASS_HYBRID")
public class FcAccountClassHybrid {

	@Id
	private String accountClass;

	private String description;

	public String getAccountClass() {
		return accountClass;
	}

	public void setAccountClass(String accountClass) {
		this.accountClass = accountClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FcAccountClassHybrid [accountClass=" + accountClass + ", description=" + description + "]";
	}

}
