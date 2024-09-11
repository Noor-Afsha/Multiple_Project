package com.Wecoodee.CustomerAppliaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wecoodee.CustomerAppliaction.Dto.ApiResponse;
import com.Wecoodee.CustomerAppliaction.Dto.CreateCustomerAccountApplicationDTO;
import com.Wecoodee.CustomerAppliaction.model.CustAccAppl;
import com.Wecoodee.CustomerAppliaction.service.CustAccApplicationService;

@RestController
@RequestMapping("/custAccApp")
public class CustAccApplController {

	@Autowired
	private CustAccApplicationService custAccApplicationService;

	public ApiResponse<Object> deleteController(String applicationNumber) {
		return custAccApplicationService.deleteByIdService(applicationNumber);
	}

	public ApiResponse<CustAccAppl> create(CreateCustomerAccountApplicationDTO customerApplicationDto) {
		return custAccApplicationService.createService(customerApplicationDto);
	}

	@GetMapping("/close/{applicationNumber}/{userRemark}")
	public ApiResponse<CustAccAppl> closeController(@PathVariable("applicationNumber") String applicationNumber,
			@PathVariable("userRemark") String userRemark) {
		return custAccApplicationService.close(applicationNumber, userRemark);
	}
//	 @GetMapping("/getApplicationApproverByRoleId/{roleId}")
//	    public ApiResponse<List<LookupValues>> geApproverListByRoleIdController(@PathVariable("roleId") String roleId) {
//	        return custAccApplicationService.getApproverListByRoleIdService(roleId);
//	    }
}
