package com.example.listOfObject.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;

	@Column(name = "doc_req", columnDefinition = "json")
	private List<String> docReq;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDocReq() {
		return docReq;
	}

	public void setDocReq(List<String> docReq) {
		this.docReq = docReq;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", docReq=" + docReq + "]";
	}

}
