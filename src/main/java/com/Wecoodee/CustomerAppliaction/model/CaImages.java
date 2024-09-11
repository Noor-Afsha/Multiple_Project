package com.Wecoodee.CustomerAppliaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CA_IMAGES")
public class CaImages {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long imageId;

	private String imageType;

	private String imageData;

	private String fileName;

	private String title;

	private String custId;

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "CaImages [imageId=" + imageId + ", imageType=" + imageType + ", imageData=" + imageData + ", fileName="
				+ fileName + ", title=" + title + ", custId=" + custId + "]";
	}

}
