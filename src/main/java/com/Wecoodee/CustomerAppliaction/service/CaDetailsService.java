package com.Wecoodee.CustomerAppliaction.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.catalina.connector.Response;
import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.springframework.beans.factory.annotation.Autowired;

import com.Wecoodee.CustomerAppliaction.Dto.ApiResponse;
import com.Wecoodee.CustomerAppliaction.model.CaDetails;
import com.Wecoodee.CustomerAppliaction.repository.CaDetailsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wecodee.springflow.common.constant.EnumData;
import com.wecodee.springflow.common.constant.ResponseMessage;
import com.wecodee.springflow.operation.caapplication.constant.ApplicationAction;
import com.wecodee.springflow.operation.caapplication.constant.ApplicationStatus;
import com.wecodee.springflow.operation.caapplication.constant.ApplicationType;
import com.wecodee.springflow.operation.caapplication.dto.CustomerResponseDTO;
import com.wecodee.springflow.operation.caapplication.model.CaApplErrors;

public class CaDetailsService {
	@Autowired
	private CaDetailsRepository caDetailsRepository;

public ApiResponse createCustomer(CaApplDto caApplDto) {
	
	log.info("create customer method is executed");
	
	try {
		CaDetails caDetails=CaApplDto.getCaDetails();
		
		//check user access
		
		if(!accessManagementService.checkUserAccess(Helper.getActiveUser(),Function,Customer_Application.getName(),Enum.create_Access.getName()));
		{
		return ApiResponse.failure(Response.getMessage.getName);
		}
		
		//validate mandatory field
		List<CaDetails> caDetalList=new ArrayList<>();
		
		caDetalList.add(caDetails);
		
		ApiResponse apiResponse=customerValidateService.customerValidate(CaDetails);
		if(apiResponse!=null) {
			return apiResponse;
		}
		
		//validate Customer Duplicate
		if(!caApplDto.isConfirming) {
			ApiResponse apiResponseSaved=CustomerValidateService.checkDuplicate(caDetails.getCustId(),
					caDetails.getNationalId(),caDetails.getAgentName(),caDetails.getApplicationNumber(),
					caDetails.getNationality());
			if(apiResponseSaved !=null && apiResponseSaved==2) {
				return apiResponseSaved;
			}
		}
		
	//generate and set custId
		String custId=commonService.GenerateCustomerId("customer");
		
		caDetails.setCustId(custId);
		
		if(caDetails.getCaDetailsPersonals()!=null ) caDetails.getCaDetailsPersonals.setcustId(custId);
		
		if(caDetails.getCaDetailsCorporates()!=null)  caDetails.getCaDetailsCorporates.setcustId(custId);
	
		if(caDetails.getCaAdditionalFields()!=null ) caDetails.getCaAdditionalFields.setcustId(custId);
		
		if(caDetails.getCaImages()!=null && caDetails.getCaImages().size()>0);
		caDetails.getCaImages().forEach(img -> img.setCustId(custId));

		if(caDetails.getCaDocuments()!=null && caDetails.getCaDocuments().size()>0);
		caDetails.getCaDocuments().forEach(doc -> doc.setdoc(custId));
		
		if(caDetails.getCaOperationInstructions()!=null && caDetails.getCaOperationInstructions().size()>0);
		caDetails.getCaOperationInstructions().forEach(op -> op.setCustId(custId));
		
		
		//validate if customer is duplicate and value stored
		
		if(!caApplDto.isConfirming()) {
			ApiResponse apiResponse2=customerValidateService.checkDuplicate(caApplDto.getcaDetails.getcustId(),
					ApplicationType.CUSTOMER_APPLICATION.getName(), caApplDto.caDetails.getCustomerNumber(),
					caApplDto.caDetails.getCustomerName);
			
			if(apiResponse2 !=null && apiResponse2.getStatus()==2) {
				List<errApp> caApplEventsService=(List<errApp>apiResponse2.getData);
				errappRepository.saveAll(caApplEventsService);
			}
		}
		
		//set audit properties
		
		caDetails.setApproved(false);
		caDetails.setPendingApproved(true);
		caDetails.setRecordVersin(Integer.valueOf(1));
		caDetails.setCreatedBy(Helper.getActiveUser);
		caDetails.setCreatedDate((Helper.currentDateAndtime()));
		caDetails.setRecordStatus(EnumData.Active.getName());
		caDetails.setLastUpdatedBy(null);
		caDetails.setLastUpdatedDate(null);	
		caDetails.setApprovedBy(null);
		caDetails.setApplicationNumber(ApplicationStatus.BRANCH_PENDING_APPROVAL.getName());
		caDetails.setApplicationAction(ApplicationAction.CREATE_CTION.GETName());
		caDetails.setOriginSource("SPRINGFLOW");
		

        //save the customer application
        caDetails caDetailsSaved=caDetailsRepository.save(caDetails);
        
        caApplEventsService.logCaApplEvent(caDetails.getCustId(),CaDetails.getcaDetails.getApplicationStatus(), EnumData.USER_ALERT_PENDING_APPROVAL.getName(), null, EnumData.CREATE_ACTION.getName(), customerApplDTO.getUserRemarks());

        
        //send notification
        log.infp("workflow is sending the information");
        

        ThreadUtil.executeInNewThread(() -> {
            try {
            	 workFlowNotification.sendNewCustomerCreatedNotification(caDetailsSaved);
            } catch (MessagingException e) {
                log.error("Failed to send workflow notification of application creation");
            }
        });
        
        log.error("returning from cutomer application service -create method");
        return ApliResponse.succes(ResponseMessage.CUSTACCAPPL_CREATED_SUCCESS.getMessage(),caDetailsSaved);
     }  
	catch(Exception e) {
		log.error("failed to create cust acc appl" ,e);
	}
return  ApiResponse.failure(ResPonseMessage.operation_failed.getMessage());
	
}

	public ApiResponse updateService(CaDetails caDetails) {
		log.info("update service method is executed");
		try {
			CaDetails caDetailss = caDetailsRepository.getById(caDetails.getCustId());
			if (caDetailss != null) {
				caDetails.setCustId(caDetailss.getCustId());
				CaDetails d = caDetailsRepository.save(d);
				return ApiResponse.success(ResponseMessage.customer_record_updated.getMessage(caDetailss),caDetails);
				else {
					return ApiResponse.failure(ResponseMessage.customer_record_failed.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ApiResponse.failure(ResponseMessage."OPERATION_FAILED".getMessage());
		}
	}

	public ApiResponse<CaDetails> updateCustomer(CustomerAppDto customerAppDto) {
		log.info("update customer method is executed");
		try {
CaDetails caDetails=customerAppDto.getCaDetails();
if(!accessManagemenService.checkUserSerice(Helper.getActiveUser(),Function."CUSTOMER_APPLICATION".getName(),Enum."CREATE_ACCESS".getName()));
return ApiResponse.failure(ResponseMessage."Access_ not_available_for_user".getMessqage);

//setting default values
caDetails =setDefaultValues(caDetails);

//validate mandatory fields
List<CaDetails> caDetailsList=new ArrayList<caDetails>();
caDetailsList.add(caDetails);
ApiResponse<CaDetails> CaDetails=customerValidateService.valdateService(caDetailsList);

//check whether the object is null or nt?
if(caDetailsList !=null) {
return apiResponse;
}

//validate customer is duplicate or not?
if(!customerAppDto.IsConfirmWarning()) {
	string tinNo ="";
	if(CustomerDto.getCaDetails.getCustomerType.equals("C") && CustomerAppDto.getCaDetils().getCaDetailsCorporate().getTinNo !=null) {
		tinNo=customerAppDto.getCaDetails().getcaDetailsCorporate().getTinNo();
		else {
			tinNo="";
		}
	}
	
	ApiResponse custAccApiResponse=customerValidateService.checkDuplicateService(CutomerAppDto.getCaDetails.getCustId(), ApplicationType."Customer_Application".getName(),CustomerAppDto.caDetails.getCostomerType(),CustomerAppDto.getCaDetails.getCustomerName(),CustomerAppDto.getCaDetails.getCountryCode(),CustomerAppDto.getCaDetails.getTinNo());
	if(custAccApiResponse !=null && custAccApiResponse.getStatus ==2) {
		return custAccApiResponse;
	}
	
}
CaDetails caDetailsDb=null;
CaDetails caDetailsSaved=null;
if(caDetails.getCustId()!=null && !caDetails.getCustId().equals("")) {
CaDetails caDetailsDb=caDetailsRepository.findByCustId(caDetails.getCustId());
else if(caDetails.getCustomerNumber() !=null && !caDetails.getCustomerNumber().equals(""));
apiRespnse=getByCustomerNumber(caDetails.getByCustomerNumber();
if(apiResponse.getStat==0);
return apiResponse;

caDetailsDb=mapper.convertValue(apiRespnse.getData(),caDetails.class())
		}

int recordVersion =1;

if(Helper.defaultNull(caDetailsDb.getCustId().isEmpty())) {
	log.info("first time modification");
	String custId=commonService.f=generateApplicationNumber("customer");
	caDetails.setCustId(custId);
	if(caDetails.getCaDetailsPersonals()!=null, caDetais.getCustId().setCustId(custId));
	if(caDetail.getCaDetailsCorporate()! =null, caDetails.getCustId().setCustId(custId));
	if(caDetail.getCaDetailsFields() !=null, caDetails.getCustId().setCustId(custId));
	
	recordVersion= recordVersion +1;
	
	caDetails.setRecordVersion(recordVersion);
	caDetails.setApproved(false);
	caDetails.setPendingApproval(true);
	caDetails.setCreatedby(Helper.getAactiveUser);
	caDetail.setCreatedDate(Helper.currentDateAndTime())
	caDetails.setLastUpdatedBy(Helper.getActiveUser);
	caDetails.setLastUpdatDate(helper.currentDateAndTRime());
	caDetails.setApprovedBy("");
	caDetails.setApproveDate(null);
	caDetails.setKycApproveBy("");
	caDetails.setkycApprovedDate(null);
	caDetails.setApplicationStatus(Enum.Branch_pending_approval.getName());
	caDetails.setApplicationAction(Enum.update_action.getName());
}else {
	 log.info("Application status " + caDetails.getApplicationStatus());
     if (!(caDetailsDb.getApplicationStatus().equals(ApplicationStatus.BRANCH_MODIFICATION_REQUIRED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.KYC_MODIFICATION_REQUIRED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.KYC_REJECTED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.BRANCH_REJECTED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.KYC_APPROVED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.BRANCH_APPROVED.getName()))) {
         return ApiResponse.failure(ResponseMessage.CUSTACCAPPL_INCORRECT_MODIFY_STATUS.getMessage());
     }

     if (caDetailsDb.getApplicationStatus().equals(ApplicationStatus.BRANCH_MODIFICATION_REQUIRED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.BRANCH_REJECTED.getName())) {
         recordVersion = caDetailsDb.getRecordVersion() + 1;
         caDetails.setRecordVersion(recordVersion);
         caDetails.setApproved(false);
         caDetails.setPendingApproval(true);
         caDetails.setLastUpdatedBy(Helper.getActiveUser());
         caDetails.setLastUpdatedDate(Helper.getCurrentDateAndTime());
         caDetails.setApprovedBy("");
         caDetails.setApprovedDate(null);
         caDetails.setKycApprovedBy("");
         caDetails.setKycApprovedDate(null);
         caDetails.setApplicationStatus(EnumData.BRANCH_PENDING_APPROVAL.getName());
         caDetails.setApplicationAction(ApplicationAction.CREATE_ACTION.getName());
}
} else if (caDetailsDb.getApplicationStatus().equals(ApplicationStatus.KYC_MODIFICATION_REQUIRED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.KYC_REJECTED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.KYC_APPROVED.getName()) || caDetailsDb.getApplicationStatus().equals(ApplicationStatus.BRANCH_APPROVED.getName())) {
    log.info("Saving the record in history table");
    Boolean savedToHistory = storeToHistory(caDetailsDb);

    if (!savedToHistory) {
        return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
    }
    recordVersion = caDetailsDb.getRecordVersion() + 1;
    caDetails.setRecordVersion(recordVersion);
    caDetails.setApproved(false);
    caDetails.setPendingApproval(true);
    caDetails.setLastUpdatedBy(Helper.getActiveUser());
    caDetails.setLastUpdatedDate(Helper.getCurrentDateAndTime());
    caDetails.setApprovedBy("");
    caDetails.setApprovedDate(null);
    caDetails.setKycApprovedBy("");
    caDetails.setKycApprovedDate(null);
    caDetails.setApplicationStatus(EnumData.BRANCH_PENDING_APPROVAL.getName());
    caDetails.setApplicationAction(ApplicationAction.UPDATE_ACTION.getName());
}
}
		if(CustomerAppDto.IsConfirmWarning()) {
			String tinNo="";
			 if (customerApplDTO.getCaDetails().getCustomerType().equals("C") && customerApplDTO.getCaDetails().getCaDetailsCorporate().getTinNo() != null) {
                 tinNo = customerApplDTO.getCaDetails().getCaDetailsCorporate().getTinNo();
             } else {
                 tinNo = "";
                 
                 ApiResponse custAccApplApiResponse = customerValidateService.checkDuplicateCustomer(customerApplDTO.getCaDetails().getCustId(), ApplicationType.CUSTOMER_APPLICATION.getName(), customerApplDTO.getCaDetails().getCustomerNumber(), customerApplDTO.getCaDetails().getCustomerName(), customerApplDTO.getCaDetails().getCustomerType(), customerApplDTO.getCaDetails().getMobileNo(), customerApplDTO.getCaDetails().getNationalId(), tinNo);
                 if (custAccApplApiResponse != null && custAccApplApiResponse.getStatus() == 2) {
                     List<CaApplErrors> caApplErrorsList = (List<CaApplErrors>) custAccApplApiResponse.getData();
                     caApplErrorRepository.saveAll(caApplErrorsList);
                 
             }
		}
			 caChangeLogService.changeLogCaDetails(caDetailsDb.getCustId(), recordVersion, caDetailsDb, caDetails);

	            caApplEventsService.logCaApplEvent(caDetails.getCustId(), EnumData.BRANCH_PENDING_APPROVAL.getName(), EnumData.USER_ALERT_MODIFY.getName(), null, EnumData.UPDATE_ACTION.getName(), customerApplDTO.getUserRemarks());

	            caDetailsSaved = caDetailsRepository.save(caDetails);

	            return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), caDetailsSaved);


		}catch(

	Exception e)
	{
		e.printStackTrace();
	}
}

	public ApiResponse<CaDetails> branchModificationRequiredService(String applicaionNumber, String userName) {
		log.info("branch modification required service is execute");
		if (!accessManagementservice.checkUserName(Helper.getActiveUser(), Function.CustomerApplication.getName(),
				EnumData.Create_Access.getName())) {
			return ApiResponse.failure(ResponseMessage.access_not_available_for_create_access.getMessage());
			try {
				CaDetails caDetails = caDetailsRepository.findByCustId(applicaionNumber);

				List<String> activeBranchUser = userUtil.getActiveUserBranchAccess();
				if (!activeBranchUser.contains(caDetails.getCustomerBranch())) {
					log.info("user branch do not have access");
					return ApiResponse.failure(ResponseMessage.user_branch_has_ristricted.getMessage());
				}

				caDetails.setApproved(false);
				caDetails.setPendingApproval(true);
				caDetails.setApplicationStatus(branch Required modification);
				CaDetais caDetails1=caDetailsRepository.save(caDetails);
				
				caAppEventService.logCaEvent(caDetails1.getCustid(),EnumData.branch_modification_required.getName(),EnumData.Alert_Modifying.getName() null,EnumDatamodification_required.getName(),userRemarks);
				
				if(caDetail1 !=null) {
					log.info("sending for approval");
					
					ThreadUtil.executeInNewThread(() ->
					try {
					    workFlowNotification.sendNewCustomerModificationRequiredNotification(caDetails1, userRemark);
                    } catch (MessagingException e) {
                        log.error("Failed to send workflow notification for modification requried", e);
                    }
					
                    });
					
				}
            return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), caDetails1);

			} catch (Exception e) {
	            return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());

			}

		}

	public ApiResponse<CaDetails> reject(String applicationNumber, String userRemarks) {
		log.info("reject service method is executed");
		CaDetails caDetail = caDetailsRepository.findByCustId(applicationNumber);

		try {
			if (!accessManagementService.checkUserAccess(Hekper.getActiveUser(),
					Function.CustomemrApplication.getName(), EnumData.approve_access.getName())) {
				return ApiResponse.failure(ResponseMessge.approve_access_not_available_for_rejected_user.getMessage());
			}
			if (!accessManagementService.checkApprover(caDetails.getCreatedBy())) {
				return ApiResponse.failure(ResponseMessage.maker_cannot_reject.getMessage());
			}

			List<String> activeBranchUser = userUtil.getActiveUserBranchAccess();
			if (!activeBranchUser.contains(caDetails.getCustomerBranch())) {
				log.info("user branch do not have access");
				return ApiResponse.failure(ResponseMessage.user_branch_has_ristricted.getMessage());
			}
			caDetails.setApproved(true);
			caDetails.setRecordStatus(EnumData.REJECT.getName());
			caDetails.setLastUpdatedBy(Helper.getActiveUser());
			caDetails.setLastUpdatedDate(Helper.getCurrentDateAndTime());
			caDetails.setPendingApproval(false);
			caDetails.setApplicationStatus(EnumData.BRANCH_REJECTED.getName());
			CaDetails custAccountApplication = caDetailsRepository.save(caDetails);

		} catch (Exception e) {
		}

	public ApiResponse<CaDetails> approveService(String applocationNumber, String userName, String userRemarks){
		log.ingo("approve  Service method is executed");
		CaDetail caDetail=caDetailsRepository.findByCustId(applocationNumber);
		try {
			if(!accessManagrment.checkUserAccees.findByCustId(),Function.CustomerApplication.getName(),EnumData.createAccess.getName()) {
				return ApiResponse.failure(ResponseMessage.user_do_not_have_access_to_aapprove.grtMessage());
			}
			if(!accessManagementService.checkApprover(caDetail.getCreatedBy())) {
				return ApiResponse.failure(ResponseMesaage.maker_cannot_approve.getMessage())
			}
			
			List<String> userBranchAccess=userUtil.getActiveUserBranchAccess();
			if(userBranchAccess.contains(caDetail.customerApplication) {
				return ApiResponse.failure(ResponseMessage.userNotHAveAccessIsStrictly,getMessage())
			}
			
			 log.info("Record version :", caDetailsDb.getRecordVersion());
	            ApiResponse<CustomerResponseDTO> apiResponse = new ApiResponse<>();
	            if (caDetailsDb.getApplicationStatus().equals(EnumData.BRANCH_PENDING_APPROVAL.getName()) && caDetailsDb.getApplicationAction().equals(EnumData.CREATE_ACTION.getName())) {
	                log.info("Create customer account in CBS");
	                apiResponse = bankingService.createCustomerOnly(caDetailsDb);
	                log.info("after getting response from fcubs", apiResponse.getData());
	            } else if (caDetailsDb.getApplicationStatus().equals(EnumData.BRANCH_PENDING_APPROVAL.getName()) && caDetailsDb.getApplicationAction().equals(EnumData.UPDATE_ACTION.getName())) {
	                log.info("Modify customer account in CBS");
	                apiResponse = bankingService.brApproveUpdateCustomerOnly(caDetailsDb);
	            }
	            ObjectMapper mapper = new ObjectMapper();

	            CustomerResponseDTO customerResponseDTO = null;
	            if (apiResponse.getStatus() == 0) {
	                customerResponseDTO = mapper.convertValue(apiResponse.getData(), CustomerResponseDTO.class);

	                
	                caApplErrorRepository.saveAll(customerResponseDTO.getCaApplErrors());

	                
	                return ApiResponse.failure("Failed to create/update customer in Flexcube", customerResponseDTO);
	                
	                
	            }else {
	                	customerResponseDTO=mapper.convertValue(apiResponse.getData(), CustomerResponseDTO.class);
	                	log.info("customer response dto ", customerResponseDTO);
	                	CaDetails caDetailsResponse-customerResponseDTO.getCaDetails();
	                }
		  } else if (caDetailsDb.getKycStatus() != null && !caDetailsDb.getKycStatus().equals("KYC_APPROVED")) {
              caDetailsResponse.setApplicationStatus(ApplicationStatus.KYC_PENDING_APPROVAL.getName());
              caDetailsResponse.setHoAssignedTo(hoAssignedTo);
              caApplEventsService.logCaApplEvent(caDetailsDb.getCustId(), EnumData.KYC_PENDING_APPROVAL.getName(), EnumData.USER_ALERT_APPROVED.getName(), hoAssignedTo, EnumData.APPROVE_ACTION.getName(), userRemark);
          }

      }caDetailsResponse.setApproved(true);caDetailsResponse.setPendingApproval(false);caDetailsResponse.setApprovedBy(Helper.getActiveUser());caDetailsResponse.setApprovedDate(Helper.getCurrentDateAndTime());

	CaDetails caDetailsFrmDb = caDetailsRepository.save(caDetailsResponse);

	try
	{
		workFlowNotification.sendNewCustomerApprovedNotification(caDetailsFrmDb);
	}catch(
	MessagingException e)
	{
		log.error("Failed to send workflow notification for application approval", e);
	}});}return ApiResponse.success(ResponseMessage.CUSTACCAPPL_BRAPPROVED_SUCCESS.getMessage(),customerResponseDTO);

	}catch(
	Exception e)
	{
		e.printStackTree();
	}

	public ApiResponse<CaDetails> get(String custId){
			log.info("log method service is executed");
			try {
				
				CaDetails caDetails=caDetailsRepository.findByCustId(custId);
				if(caDetails !=null) {
					return ApiResponse.success(ResponsMessage.operation_success.getMessage(),caDetails);
					else {
						return ApiResponse.failure(ResponseMessage.operation_failed.getMessage())
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return ApiResponse.failure(ResponseMesssage.operation_failed.getMessage());
				}
	}

	public ApiResponse<CaDetails> getByCustomerNumber(String customerNumber){
		log.info("get by customere number is executed");
	CaDetails caDetails=caDetailsRepository.findByCustomerNumber(customerNumber);
	try {
		if(caDetails !=null) {
			return ApiResponse.success(ResponseMessage.operation_success.getMessage(),caDetails);
			
			else {
				
				  ApiResponse<CaDetails> caDetailsApiResponse = new ApiResponse<>();
	                caDetailsApiResponse = this.bankingService.getCustomerDetails(customerNumber);
	                log.info("CBS response status " + caDetailsApiResponse.getStatus());
	                if (caDetailsApiResponse.getStatus() == 1) {
	                    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	                    caDetails = mapper.convertValue(caDetailsApiResponse.getData(), CaDetails.class);
	                    caDetails.setApplicationStatus(ApplicationStatus.BRANCH_VIEW.getName());
	                    return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), caDetails);
	                }
	                else {
	                    return ApiResponse.failure("Failed to get customer details from Flexcube");
	                }
	            }
			
			}
	} catch (Exception e) {
		return ApiResponse.failure(ResponseMessage.operation_failed.getMessage());
e.printStackTrace();	}
		
	}
}
