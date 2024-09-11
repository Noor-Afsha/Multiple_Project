package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CA_OPERATION_INSTRUCTION")
public class CaOperationInstruction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int operationId;

	private String custId;

	private boolean atmCard;

	private boolean mobileBanking;

	private boolean internetBanking;

	public int getOperationId() {
		return operationId;
	}

	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public boolean isAtmCard() {
		return atmCard;
	}

	public void setAtmCard(boolean atmCard) {
		this.atmCard = atmCard;
	}

	public boolean isMobileBanking() {
		return mobileBanking;
	}

	public void setMobileBanking(boolean mobileBanking) {
		this.mobileBanking = mobileBanking;
	}

	public boolean isInternetBanking() {
		return internetBanking;
	}

	public void setInternetBanking(boolean internetBanking) {
		this.internetBanking = internetBanking;
	}

	@Override
	public String toString() {
		return "CaOperationInstruction [operationId=" + operationId + ", custId=" + custId + ", atmCard=" + atmCard
				+ ", mobileBanking=" + mobileBanking + ", internetBanking=" + internetBanking + "]";
	}

}
