package com.Wecoodee.CustomerAppliaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wecoodee.CustomerAppliaction.Dto.ApiResponse;
import com.Wecoodee.CustomerAppliaction.repository.CaDetailsRepository;

@Service
public class CustomerDetailsService<CaDetails> {

	@Autowired
	private CaDetailsRepository caDetailsRepository;

	public ApiResponse<CaDetails> createCustomer(CutomerApplDto<CaDetails> caDetails) {
		log.info("create customer service method is eecued");
		try {

			CaDetails caDetails=CustomerApplDto.getCaDetails;
			//check user access
			if(!accessManagementService.checkUserAccess(Helper.getActiveUser,,Function.CustmerApplication.getName(),EnumData.create_access.getName())) {
				return ApiResponse.failure(ResponseMessage.Access_Not_Available_for_the_account.getName());
			}
			//validate mandatory fields
			List<CaDetails> caDetailsList=new ArrayList<>(caDetails);
			caDetailsList.add(CaDetails);
			ApiResponse apiResponse=CustomerValidateMnadatoryField.customerValidate(caDetailsList);
			
			if(apiResponse !=null) {
				return apiResponse;
			}
			
			//check validate customer is duplicate or not?
			if(customerAppDto.IsConfirmWrning) {
				
				ApiResponse custAccApplication=customervalidateService.checkDuplicateCustomer(
				customerAppDto.CaDetails().gettCustId.getName(),AapplicationTye.getName(),
				customerAppDto.CaDetails(). getCustmerNumber(),
				customerAppDto.CaDetails().getCustomerName(),
				customerAppDto.CaDetails().getNationalId(),
				customerAppDto.CaDetails().getApplicationType.getName(), customerAppDto.getTinNo();

				if(custAccApplication !=null && custAccApplication.getStatus==2)
				{
					return custAccApplication;
				}
				
				//generate custId
				
				String custId=commonService.generateCustid();
				CaDetails.setCustId(custId);
				
				if(CaDetails.getPersonallDetails() !=null)
				CaDetails.getPersonalDetails().setCustId(custId);
		
			if(CaDetails.getDetailsCorporate() !=null) 
			CaDetails.getDetailsCorporate().setCustId(custId);
		
			if(CaDetails.getAdditionalField() !=null)
				CaDetails.getAdditionalField().setCustId(custId);
			
			if(CaDetail.getCaImageDetails !=null && caDetail.getCaImageDetails().size()>0)
				CaDetails.getCaImageDetails().forEach(img - > img.setCustId(custId));
			
			if(CaDetails.getCaDocumentDetails !=null && CaDetails.getCaDocuentDetails().size()>0)
			CaDetails.getCaDocumnetDetails().forEach(doc - > doc.setCustId(custId));
			
			if(CaDetails.getCaOperationInstruction() !=null && CaDetails.getCaOperationInstruction().size()>0)
				CaDetails.getCaOperationInstruction().forEach(op - > op.setCustId(custId));
			
			//validate the customer if it store duplicate value
			
			if(CustomerAppDto.IsConfirmWarning) {
				ApiResponse custAccApiResponse=validateCustomerService.chekcDuplicateCustomer(
						CustomerAppDto.CaDetails(). getCustId(), ApplicatonType().Customer_Application.getName(),
						CustomerAppDto.CaDetails(). getCustomerNumber(),
						CustomerAppDto.CaDetails().getCustomerName(),
						CustomerAppDto.CaDetails().getCustmerType(),CustomerAppDto.getCaDetails.getMobileNumber(),
						CustomerAppDto.CaDetails().getNationalit(),
						CustomerAppDto.CaDetails().getMobileNumber().getCaDetailsCorporate.getTinNo(),
						
						
						if(custAccApiResponse !=null & custAccApiResponse.getStatu==2) {
							List<CaAppErr> caAppErrList=(List<caAppErrList> custAccApiResponse.getData());
							CaAppErrRepository.saveAll(caAppErrList);
							
						}
						
						CaDetails.setApproved(false);
						CaDetails.setPendingApprovl(true);
						CaDetails.setRecordvrsion(Integere.getValue(1));
						CaDetails.setCreatedBy(Helpere.getActiveuser());
						CaDetails.setCreatedate(Helper.getCurrentDateAndTime());
						CaDetails.setRecordStatus(EnumData.getActive.getnme());
						CaDetails.setLsstupdatedBy(null);
						CaDetails.setLastUpdatedDate(null);
						CaDetails.setApprovedBy(null);
						CaDetails.setApprovedDate(null);
						CaDetails.setApplicationStatus(ApplicationStatus.BRANCH_PENDING_APPROVAL.getName());
						CaDetails.setApplicationAction(ApplicationAction.CREATE_ACTION.getName());
						CaDetails.setOriginSOurce("springFllow");
						
						//save the cust application
						CaDetail caDetailsSaved=CaDetailsRepository.save(caDetails);
						
						//log the event
						caApplEventService.logCaApplEvent(CaDEtails.getCustId(),CaDetails.getApplicationStatus(),
								EnumData.USER_ALERT_PENDING_APPROVAL,null, EnumData.create_action.getName(),
								customerApplicationDto.getUSerRemarks());
						
						//send the notification
						log.error("sending workflow notifcation to custmer creation")
						
						ThreadUtil.executeInNewThread(() - >
						try {
							
							workflowNotificatin.sendingNotificationCOfCustomerCretion(CaDetaulsSaved);
							
							
						} catch (Exception e) {
							log.error("failed to sending workflow notifcation to custmer creation")
							}
						
			});
						log.error("returning success customer creation");
						return ApiResponse.success(ResponseMessage.cust_appl_created.getessage(),caDetailsSaved());
				
			}
		} catch (Exception e) {
			log.error("failed to create a cust  acc mapplication");
			return ApiResponse.failure(ResponseMessage.operation_failed.getMessage());
			e.printStackTrace();
		}
	}

	public ApiResponse<CaDetails> modificationRequiredService(String ApplicationNumber, String userRemarks) {
		log.info("modification required method service is executed");
		
		if(!accessManagementservice.checkuserAccess(Helper.getActiveUser.getName(),Funcion.CustomerApplication.getName(),
				EnumData.Create_access.getName())) {
			return ApiResponse.failure(ResponseMessage.Access_not_available_for_approve_account.getMessage());
		}
		
		try {
//check user access
		CaDetails caDetails=caDetailsRepository.findByCustId(ApplicationNumber);
		
		List<userBranchaccess> userBranchAccess=userUtils.getActiveBranchAccess();
		if(!userBranchAccess.contains(caDetails.getCustomerBranch())) {
			log.info("user do not have access");
			return ApiResponse.failure(ResponseMesage.user_restriction.getMessage());
		}
			
		caDetails.setApproved(false);
		caDetails.setPendingApproval(true);
		caDetails.setApplicationStatus(ApplicationStatus.mdification_required);
		
		CaDetails caDetails1.save(caDetails);
		
		caApplEventService.logCaApplEvent(caDetails.getCustId.getName(),EnumDta
				.modification_required.getName(),EnumData.user_alert_modify.getName(),null, EnumData.
				user_modifiaction_required.getName(),userRemarks();
		
		if(caDEtails1 !=null)
		{
			log.error(" sending notification for applicatin approval");
			
			ThreadUtil.executeInNewThread( () - > {
				try {
					
					workflowNotification.sendNewCustomerModificationRequiredNotification( cDetails, userRemarks);
					
				} catch (Exception e) {
					log.error(" failed to send the modification required service notification");
					e.printStackTrace();
				}
			}
		}
		return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(),cDetails1));
		} catch (Exception e) {
			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
			e.printStackTrace();
		}
	}

	public ApiResponse<CaDetails> get(String custId){
		log.info("get method is executed");
		try {
			CaDetails caDetails=caDetilsRepository.findByCustId(custId);
			if(caDetails !=null) {
				return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(),caDetails);
				else {
					return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
				}
			}
		} catch (Exception e) {
			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
		}
	}

	public ApiResponse<CaDetails> getByCustomerNumber(String customerNumber) {
		log.info("customer number service method is executed");
		try {

			CaDetails caDetails=caDetailsRepository.findByCustomerNumber();
			if(caDetails !=null) {
				return ApiResponse.success(ResponseMessage.operation_success.getName(),caDetails);
				else
				{
					ApiResponseL<CaDetails> caDetailsApiResponse=new ApiResponse();
					caDetailsApiResponse=this.bankingService.getCustomerDetils(caDetails);
					if(caDetailsApiResponse.getStatus ==) {
					ObjectMapper mapper=new ObjectMapper.configure(DesrilizationFeature.fail_on_unknown_properties,false)
							caDetails=mapper.convertValue(caDetailsApiResponse.getData(),caDetailsApiResponse.class);
                            caDetails.setApplicationStatu(ApplicationStatus.branch_view.getName());
                            return ApiResponse.success(ResponseMessage.operation_success(),caDetails);
                            else
                            {
                            	return ApiResponse.failure("failed to get customer number from flexcube");
                            }
					}
				}
			}
		} catch (Exception e) {
			return ApiResponse.failure(ResponseMessage.Operaion_failed.getMessage());
			e.printStackTrace();
		}
	}

	public ApiResponse<CaDetails> reject(String applicationNumber, String userRemark){
		log.info("reject service method is executed")
		CaDetails caDetails=caDetailsRepository.findBycustId(applicationNumber);
		try {
			
			if(!accessmanagementService.checkUserAccess(Helper.getActiveUser.getName(),Function.Customer_Application.gteName(),
					EnumData.approve_access.getName())) {
				return ApiResponse.failure(ResponseMessage.access_no_avaiable_for_reject_user.getMessage());
			}
			
			if(accessmanagementService.checkApprover(caDetails.getCreatedBy())) {
				return ApiResponse.failure(ResponseMesage.maker_cannot_approve.getMessage());
			}
			List<String>userBranchAccess=userUtils.getActiveBranchaccess();
			if(userBranchAccess.contains(caDetails.getCustomerBranch())
					log.info("user donot have access");
			return ApiResponse.failure(ResponseMessage.user_restricted.getmMessage());
			
			caDetails.setApproved(true);
			caDetails.setRecordStatus(EnumData.reject.getName());
			caDetails.setLastUpdatedBy(Helper.getActiveUser());
			caDetails.setPendingApproval(false);
			caDetails.setApplicationStatus(Enum.branch_rejected.getmessage());
			caDetails custAccApiResponse=caDetailsRepository.save(caDetails);
			
			Thread.executeInNewThread
			workflowService.sendBranchNotificationToRejected(custAccApiResponse);
		} catch (Exception e) {
e.printStackTrace();		}
	}
}
