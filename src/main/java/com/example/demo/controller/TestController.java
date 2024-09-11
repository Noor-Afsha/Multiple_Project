package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/adapterApi1") // calling another project first api
	public void callProjectB() {

		String url = "http://localhost:8082/adapter/api1";
		String response = restTemplate.getForObject(url, String.class);
		
//		System.out.println("hii"+ name);
	}

	@GetMapping("/adapterApi2/{name}")
	public void postingObjectToProjectB(@PathVariable String name) {
		String url = "http://localhost:8082/adapter/api2/name " + name;
		String response = restTemplate.getForObject(url, String.class);

	}

	@GetMapping("/adapterApi3")
	public String getResponse() {
		String url = "http://localhost:8082/adapter/api3";
		String response = restTemplate.getForObject(url, String.class);
		return response;

	}

	@PostMapping("/adapterApi4")
	public Object postAdapter(@RequestBody Student requestObject) {
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String url = "http://localhost:8082/adapter/api4";
//			String responses = restTemplate.getForObject(String.class);
			String jsonFormattedRequest = new ObjectMapper().writeValueAsString(requestObject);
			HttpEntity<String> entity = new HttpEntity<>(jsonFormattedRequest, headers);
			return restTemplate.postForObject(url, entity, String.class);
		} catch (Exception e) {
			logger.info("Error while making a post call to ");
			e.printStackTrace();
		}
		return requestObject;
	}

}
