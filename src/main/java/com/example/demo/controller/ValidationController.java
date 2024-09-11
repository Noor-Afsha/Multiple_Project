package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.services.ValidService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

	@Autowired
	private ValidService validService;

	@PostMapping("/post")
	public ResponseEntity<Object> test(@Valid @RequestBody Address address, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			List<String> errors = new ArrayList<>();

			for (FieldError error : bindingResult.getFieldErrors()) {

				errors.add(error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);
		}

		Address address2 = validService.test(address);
		return ResponseEntity.ok(address2);

	}
}
