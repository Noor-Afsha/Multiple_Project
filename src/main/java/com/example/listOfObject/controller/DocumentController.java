package com.example.listOfObject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.listOfObject.model.Document;
import com.example.listOfObject.service.DocumentService;
@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	  @PostMapping("/save")
	    public ResponseEntity<String> saveDocuments(@RequestBody List<Document> documentRequests) {
	        documentService.saveDocuments(documentRequests);
	        return ResponseEntity.ok("Documents saved successfully");
	    }
}
