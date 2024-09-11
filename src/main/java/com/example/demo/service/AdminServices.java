package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.TableA;
import com.example.demo.model.TableB;
import com.example.demo.repository.TableARepository;
import com.example.demo.repository.TableBRepository;

@Service
public class AdminServices {


	@Autowired
	private TableARepository tableARepository;
	@Autowired
	private TableBRepository tableBRepository;

	@Scheduled(fixedRate = 60000)
	public void moveRecordsFromAToB() {

		System.out.println("inside the method is executed");
		
		
        List<TableA> recordsFromA = tableARepository.findAll();
        
       

        for (TableA records: recordsFromA) {
        	
        	TableB b=new TableB();
        	
        	b.setId(records.getId());
        	b.setName(records.getName());
        	b.setAddress(records.getAddress());
        	
        	tableBRepository.save(b);
        	tableARepository.delete(records);
        }
	}
//	  @Scheduled(fixedDelay = 60000) // Run every minute
//	    public void scheduledTransfer() {
//		  moveRecordsFromAToB();                
//	    }


}
