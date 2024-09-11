package com.example.listOfObject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.listOfObject.model.Document;
import com.example.listOfObject.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;

	public void saveDocuments(List<Document> documentRequests) {
		if (documentRequests != null && !documentRequests.isEmpty()) {
			for (Document document : documentRequests) {
				documentRepository.save(document);
			}
		}
	}
}
