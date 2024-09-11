package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/{studentId}")
	public ResponseEntity<ResponseData> getStudentDetails(@PathVariable Long studentId){
		
		ResponseData responseData=new ResponseData();
		Students s1=new Students();
		s1.setStudentId(1);
		s1.setAddress("hydrabad");
		s1.setName("rohan");
		s1.setId(1);
		
		responseData.setStudent(s1);
		Long id=s1.getId();
		RestTemplate restTemplate=new RestTemplate();
		String endPoint="http://localhost:8081/college/{id}";
		ResponseEntity<College> data=restTemplate.getForEntity(endPoint, College.class, id );
		if(data.getStatusCodeValue()==200) {
			College c1=data.getBody();
			responseData.setCollege(c1);
		}
		
		return new ResponseEntity<ResponseData>(responseData,HttpStatus.OK);
	}
}
