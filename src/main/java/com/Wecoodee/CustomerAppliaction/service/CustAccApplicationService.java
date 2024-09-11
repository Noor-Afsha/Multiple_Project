package com.Wecoodee.CustomerAppliaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.stereotype.Service;

import com.Wecoodee.CustomerAppliaction.Dto.ApiResponse;
import com.Wecoodee.CustomerAppliaction.Dto.CreateCustomerAccountApplicationDTO;
import com.Wecoodee.CustomerAppliaction.model.CaAccounts;
import com.Wecoodee.CustomerAppliaction.model.CaApplErrors;
import com.Wecoodee.CustomerAppliaction.model.CaDetails;
import com.Wecoodee.CustomerAppliaction.model.CaDetailsPersonal;
import com.Wecoodee.CustomerAppliaction.model.CaDocuments;
import com.Wecoodee.CustomerAppliaction.model.CaJointCustomer;
import com.Wecoodee.CustomerAppliaction.model.CustAccAppl;
import com.Wecoodee.CustomerAppliaction.model.CustomerPersonalView;
import com.Wecoodee.CustomerAppliaction.model.FcAccountClassHybrid;
import com.Wecoodee.CustomerAppliaction.repository.CustAccApplRepository;
import com.Wecoodee.CustomerAppliaction.repository.FcAccountClassHybridRepository;
import com.Wecoodee.CustomerAppliaction.repository.reportingLinesMappingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wecodee.springflow.admin.model.LookupValues;
import com.wecodee.springflow.common.constant.EnumData;
import com.wecodee.springflow.common.constant.ResponseMessage;
import com.wecodee.springflow.operation.caapplication.constant.ApplicationAction;
import com.wecodee.springflow.operation.caapplication.constant.ApplicationStatus;

@Service
public class CustAccApplicationService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustAccApplRepository custAccApplRepository;

	public ApiResponse deleteByIdService(String applicationNumber) {
		log.info("deleteById method service is excuted");
		try {

			if (!accessManagementservice.checkUserAccess(Helper.getActiveUser.getName(),
					Function.CustomerAccuntApplication.getName(), EnumData.Create_Access.getName()))
				;

			return ApiResponse.failure(ResponseMessage.Access_not_allowed_for_delete_account.getMessage());

			CustAccAppl custAccAppl = custAccApplRepository.getByApplicaionNumber();

			if((custAccAppl.getCustomerNumber() !=null && custAccAppl.getCustomerNumber() !=" "
					&& (custAccAppl.getAccountNumber() !=null &&custAccAppl.getAccountNumber() !=" ")))
			{
				return ApiResponse.failure(ResponseMesssage.customer_account_delete_not_allowed);
				
				int deleteRows=custAccApplRepository.deleteByAppliactionNumber(applicationNumber);
				if(deleteRows !=0) {
					return ApiResponse.success(ResponseMessage.Operation_Successful.getMesssage(), 
							"record deleted successfully" );
					else {
						return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
					}
				}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());

		}
	}

	public ApiResponse<CustAccAppl> createService(CreateCustomerAccountApplicationDTO creaeAccountApplicationDTO) {
		log.info("create method service is executed ");
		CustomerPersonalView customerPersonalView=null;
		
		try {
			
			CustAccAppl custAccAppl=CreateCustomerAccountApplicationDTO.getCustAccAppl();
			if(!accessManagementService.checkUserAccess(Helper.getActiveUser.getName(),Function.CustomerAccountApplication.getNme(),
					EnumData.Create_Access.getMessage())) {
				return ApiResponse.failure(ResponseMessage.Access_not_avaiable_for the_create_account.getMessage());
			}
			
			ApiResponse apiResponse=CustomerValidateService.validateMandatoryFields(custAccAppl);
			if(apiResponse.getStatus()==0) {
				return apiResponse;
			}
			
			ApiResponse apiResponse1=CustomerValidateService.validateDocuments(custAccAppl.getCaDetails(),
					custAccAppl.getCaAccounts().get(0),custAccAppl.getAccountClass());
			if(apiResponse1.getStatus ==0) {
				return apiResponse1;
			}
			
			if(CreateCustomerAccountApplicationDTO.IsConfirmarning ==false) {
				
				CustAccAppl custAccAppl=CustomerValidateService.checkDuplicateCustomer(CreateCustomerAccountApplicationDTO.getCuatAccApp().getApplicaionNumber(),
				ApplicationType.CUSTOMER_ACCOUNT_APPLICATION.getName(),
				CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerNumber(),
				CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerName(),
				CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerType(),
				CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getMobileNo(),
				CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getNationalId(),
				creaeAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCaOperationInstructions().getTinNo());
				
				if(custAccAppl !=null & custAccAppl.getStatus ==2) {
					return custAccAppl;
				}
			}
			
			String applicationNumber=commonService.generateApplicationNumber("ACCOUNT");
			custAccAppl.setApplicationNumber(applicationNumber);
			custAccAppl.setApplicationType(applicationType.Customer_account_application.getName());
			custAccAppl.setApplicationDat(CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerType());
			custAccAppl.setcutomerCategory(CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerCategory());
			custAccAppl.setCustomerBranch(CreateCustomerAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerBranch());
			
			custAccAppl.setAccountBranch(custAccAppl.getCaAccount().get(0).getAccountBranc);
			custAccAppl.setAccountClass(custAccAppl.getCaAccounts().get(0).getAccountClass());
			custAccAppl.setAccountCcy(custAccAppl.getCaAccounts().get(0).getAccountCcy());
			
			List<CaDetails> cDetails=new ArrayList<>();
			for(CaDetails caDetails : custAccAppl.getCaDetails())
			{
				String custId =commonService.generateApplicationNumber("customer");
				caDetails.getCaDetailsPersonals().setCustId(custId);
				caDetails.getCaDetailsCorporates().setCustId(custId);
				caDetails.getCaAdditionalFields().setCustId(custId);
				
				if(caDetails.getOriginSource().isEmpty())
					caDetails.setOriginSource("SpringFlow");
				caDetails.setCustId(custId);
				caDetailsList.add(caDetails);
			}
			custAccAppl.setCaDetails(caDetailsList);
			
			//store joint customer details
			
			if(custAccAppl.getApplicationType().equals("j"));
			int startIndex=1;
			int endIndex=custAccAppl.getCaDetails().size();
			List<CaDetails> jointCaDetailsList=custAccAppl.getCaDetails().subList(endIndex, endIndex);
			List<CaJointCustomer> caJointCustomersList=new ArrayList<>();
			for(CaDetails caDetails :jointCaDetailsList) {
				CaJointCustomer caJointCustomer=new CaJointCustomer();
				caJointCustomer.setCustId(caDetails.getCustId());
				caJointCustomer.setCustomerBranch(caDetails.getCustomerBranch());
				caJointCustomer.setCustomerType(caDetails.getCustomerType());
				caJointCustomer.setCustomerCategory(caDetails.getCustomerCategory());
				CaJointCustomer.setApplicationNumber(caDetails.getApplicationNumber());
				caJointCustomer.setJointHolderType(caDetails.getJointHolderType());
				caJointCustomersList.add(caJointCustomer);
			}
			custAccAppl.setCaJointCustomer(caJointCustomersList);
	else {
			cutAccAppl.setCaJointCustomer(null);
		}
		
		//set the temprorary report lines
		
		apiResponse.setTemReportingGls(custAccAppl);
		if(apiResponse.getStatus ==2) {
			return apiResponse;
			
			//validate the customer if its duplicate and stores the value
			List<CaApplErrors> caAppErrorsList=new ArrayList<>();
			if(CreateCustomerAccountApplicationDTO.isConfirmWarning == true) {
				
				ApiResponse custAccAppApiResponse=customerValidateService.checkDuplicateCustomer(
						createAccountApplicationDTO.getCustAccAppl().getApplicationNumber().getApplicationType.customer_account_application.getName(),
						createAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerNumber(),
						createAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).getCustomerName()
						createAccountApplicationDTO.getCustAccApp().getCaDetails().get(0).getCustomerType(),
						createAccountApplicationDTO.getCustAccAppl().getCaDetauls().get(0),getMobileNo(),
						createAccountApplicationDTO.getCustAccAppl().getCaDetails().get(0).get(0).getcacorporateDetails().getTinNo());
				
				if(custAccAppApiResponse !=null && custAccAppApiResponse.getStatus ==2) {
					List<CaApplErrors> list=(List<CaApplErrors>) custAccAppApiResponse.getData();
					custAccAppl.setCaApplError(list);
				}
					
				}
		}	
		
		//set audit fields
		custAccAppl.setApproved(false);
		custAccAppl.setPendingApproval(true);
		custAccAppl.setRecordVersion(Integer.valueOf(1));
		custAccAppl.setCreatedBy(Helper.getActiveUser());
		custAccAppl.setCreatedDate(Helper.getCurrentDateAndTime());
		custAccAppl.setRecordStatus(EnumData.ACTIVE.getName());
		custAccAppl.setApplicationStatus(EnumData.BRANCH_PENDING_APPROVAL.getName());
		custAccAppl.setApplicationAction(ApplicationAction.CREATE_ACTION.getName());
		
		
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApproved(false));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setPendingApproval(true));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setRecordVersion(Integer.valueOf(1)));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setCreatedBy(Helper.getActiveUser()));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setCreatedDate(Helper.getCurrentDateAndTime()));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setRecordStatus(EnumData.ACTIVE.getName()));
		custAccAppl.getCaDetails()
				.forEach(caDetails -> caDetails.setApplicationStatus(EnumData.BRANCH_PENDING_APPROVAL.getName()));
		custAccAppl.getCaDetails()
				.forEach(caDetails -> caDetails.setApplicationAction(ApplicationAction.CREATE_ACTION.getName()));

		
		

		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setApproved(false));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setPendingApproval(true));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setRecordVersion(Integer.valueOf(1)));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setCreatedBy(Helper.getActiveUser()));
		custAccAppl.getCaAccounts()
				.forEach(caAccounts -> caAccounts.setCreatedDate(Helper.getCurrentDateAndTime()));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setRecordStatus(EnumData.ACTIVE.getName()));
		custAccAppl.getCaAccounts()
				.forEach(caAccounts -> caAccounts.setApplicationStatus(EnumData.BRANCH_PENDING_APPROVAL.getName()));
		custAccAppl.getCaAccounts()
				.forEach(caAccounts -> caAccounts.setApplicationAction(ApplicationAction.CREATE_ACTION.getName()));
	
		
		//set the audield ends
		

		CustAccAppl custAccountApplication = custAccApplRepository.save(custAccAppl);

		caApplEventsService.logCaApplEvent(custAccountApplication.getApplicationNumber(),
				EnumData.BRANCH_PENDING_APPROVAL.getName(), EnumData.USER_ALERT_PENDING_APPROVAL.getName(), null,
				EnumData.CREATE_ACTION.getName(), createCustomerAccountApplicationDTO.getUserRemarks());

		log.error("Sending workflow notification for application creation");

		ThreadUtil.executeInNewThread(() -> {
			try {
				workFlowNotification.sendCustAccApplCreatedNotification(custAccountApplication);
			} catch (MessagingException e) {
				log.error("Failed to send workflow notification of application creation");
			}
		});
		return ApiResponse.success(ResponseMessage.CUSTACCAPPL_CREATED_SUCCESS.getMessage(), custAccAppl);

			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed to create cust acc appl ", e);
			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
		
		}
	}

	public ApiResponse<cutAccApp> close(String applicationNumber, String userRemark) {
		log.info("close service method is executed");
		try {

			if(!accessManagementService.checkUserAccess(Helper.getActiveUser.getName(),Function.CustomerAccountApplication.getName(),EnumData.create_access.getMessage())) {
				return ApiResponse.failure(ResponseMessage.Access_no_allowed_for_create_account.getMessage());
			}
			
			CustAccAppl custAccAppFrmDb=custAccApplRepository.getByApplicaionNumber(applicationNumber);
			
			if(custAccAppFrmDb ==null) {
				return ApiResponse.failure("account_is_not_found_cannot_closed");
			}
			else {
				log.info("Application status"+custAccAppFrmDb.getApplicationNumber());
				if(!(custAccAppFrmDb.getApplicationStatus()).equals(ApplicationStatus.kyc_rejected.getMessage())) {
					return ApiResponse.failure(ResponseMessage.CUSTACCAPPL_INCORRECT_CLOSE_STATUS.getMessage());
				}
				else if(!(custAccAppFrmDb.getApplicationStatus()).equals(ApplicationStatus.kyc_rejected.getMessage())) {
				
					int recordVersion=custAccAppFrmDb.getRecordVersion() +1;
					
					custAccAppFrmDb.setApproved(false);
					custAccAppFrmDb.setpendingApproval(true);
					custAccAppFrmDb.setRecoedVersion(recordVersion);
					
					custAccAppFrmDb.setLastUpdatedBy(Helper.getActiveUser());
					custAccAppFrmDb.setLastUpdatedDate(Helper.getCurrentDateAndTime());
					custAccAppFrmDb.setApprovedBy(null);
					custAccAppFrmDb.setApprovedDate(null);
					custAccAppFrmDb.setkycApprovedBy(null);
					custAccAppFrmDbsetkycApprovedDate(null);
					custAccAppFrmDb.setApplicationStatus(ApplicaionStatus.branch_pendingApproval.getMesssage());
					custAccAppFrmDb.setApplicatioAction(ApplicationAction.BranchClased.getMesssage());
					
					CustAccAppl custAccAppl=custAccApplRepository.save(custAccAppFrmDb);
					
					if(custAccAppl !=null) {
						ThreadUtil.executeInNewThread(() { ->
						try {
							
							workFlowNotification.sendCustomerAccountClosedNotification(custAccAppl);

						} catch (Exception e) {
							log.error("Failed to send workflow notification of application creation");

                               e.printStackTrace()	;					}
						})
					}
					
				}
				caApplEventsService.logCaApplEvent(custAccApplDb.getApplicationNumber(),
						ApplicationStatus.BRANCH_PENDING_APPROVAL.getName(), EnumData.USER_ALERT_CLOSE.getName(),
						null, ApplicationAction.CLOSE_ACTION.getName(), userRemark);
				return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), custAccApplDb);
			}

	}catch(

	Exception e)
	{
			e.printStackTrace();
			log.error("In user update exception ", e);
			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
		}

	return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());

}

	public ApiResponse<CustAccAppl> get(String applicationNumber) {
		log.info("get service method for application number is executed");
		try {
			log.info(applicationNumber);
			CustAccAppl custAccAppl = custAccApplRepository.getByApplicationNumber(applicationNumber);
			if (custAccAppl.getApplicationStatus().equals(
					getApplicationStatus.kyc_pending_approval.getName() && custAccAppl.getCaApplError().size() > 0)) {

				List<CaApplErrors> caApplErrorList = new ArrayList<>();
				for (CaApplErrors caAppErrors : custAccAppl.getCaApplError()) {
					if (caAppErrors.getType() != null && caAppErrors.getType.equals("warning")) {
						caApplErrorList.add(caAppErrors);
					}
				}
				custAccAppl.setCaApplError(caApplErrorList);
				return ApiResponse.success(ResponseMessage.Operation_successfull.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ApiResponse.failure(ResponseMessage.operation_failed.getMessage());
		}
	}

	public ApiResponse<LookupValues> getApproverListByRoleIdAndUserIdService(String roleId, String userId) {
		log.info("get by approvers list by roleId and user id service method is executed");
		try {

			UserRole userRole = userRoleRepository.getByRoleIdAndUserId(roleId, userId);
			if (userRole != null) {
				LookupValues lookupValues = new lookupValues();
				lookupValues.setId("1");
				lookupValues.setName(userRole.getUserId);
				lookupValues.setValue(userRole.getUserId);
				lookupValues.setType(roleId);

				return ApiResponse.success(ResponseMEssage.Operation_success.getMessage(), lookupValues);
			}
			return ApiResponse.failure(ResponseMessage.no_records_found.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			return ApiResponse.failure(ResponseMessage.operation_failed.getmessage());
		}
	}

	public ApiResponse<CustAccAppl> modificationRequiredService(String applicationNumber, String userRemark) {
		log.info("modification required service meethod is executed");
try {
	
	CustAccAppl custAccAppl=custAccApplRepository.getByApplicaionNumber(applicationNumber);
	
	List<String> userBranchAccess=userUtil.getActiveUser();
	if(!userBranchAccess.contains(custAccAppl.getAccountBranch())) {
		log.info("user do not have returning access");
		return ApiResponse.failure(ResponseMessage.user_access_is_restricted.getMessage());
	}
	
	//set audit fields
	custAccAppl.setApprovedBy(false);
	custAccAppl.setPendingApproval(true);
	custAccAppl.setApplicationStatus(EnumData.Branch_modification_required.getName());
	
	custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApprovedBy(false));
	custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setPendingApproval(true));
	custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApplicationStatus
			(EnumData.BRANCH_MODIFICATION_REQUIRED.getName()));
	
	custAccAppl.getCaAccounts().forEach(caAccounts-> caAccounts.setApprovedBy(false));
	custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setPendingApproval(true));
	custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setApplicationStatus
			(EnumData.BRANCH_MODIFICATION_REQUIRED.getName()));
	
	custAccApplRepository.save(custAccAppl);
	
	CaApplEventService.caLogApplEvent(custAccAppl.getApplicationNumber().EnumData.BRANCH_MODIFICATION_REQUIRED().
			EnumData.USER_ALERT_MODIFY.getName().custAccAppl.createdBy().EnumData.MODIFICATION_REQUIRED.getNAme(),userRemark());
	
	
	if(custAccAppl !=null) {
		log.error("sending workflow for the approval");
		
		ThreadUtil.executeInNewThread( () -> { 
		try {
			
	workflowNotification.sendCustAccApplBranchModification(applicatinNumber, userRemark);
	
	log.info("failed to sending workflow notifciation for the approval");
	
		});
		
		}
		return ApiResponse.success(ResponseMessage.operation_success.getMessage());

		{
			return ApiResponse.failure(ResponseMessage.operation_failed.getMessage());
		}
		} catch (MessagingException e) {
			
        e.printStackTrace()	
		
	}
} catch (Exception e) {
	e.printStackTrace();
	return ApiResponse.failure(ResponseMessage.user_cannot_be_modification)
}
	}

	public ApiResponse<List<LookupValues>> getHybridAccountsList() {

		log.info("get by hybrid accounts list is executed");

		try {

			List<FcAccountClassHybrid> fcAccountClassHybridsList = FcAccountClassHybridRepository.findAll();

			if (fcAccountClassHybridsList != null && fcAccountClassHybridsList.size() > 0) {

				List<LookupValues> lookupValues = new ArrayList<>();

				for (FcAccountClassHybrid fcAccountClassHybrid : fcAccountClassHybridsList) {

					LookupValues lookupValues = new LookupValues();

					lookuValues.setName(fcAccountClassHybrid.getDescription());

					lookupValues.setValue(fcAccountClassHybrid.getAccountClass());

					list.add(lookupValues);

				}

				log.info("list of size" + list.size());

				return ApiResponse.success(ResponseMessage.FETCH_SUCCESS.getMessage(), list);
			}
			return ApiResponse.failure(ResponseMessage.NO_RECORDS_FOUND.getMessage());

		} catch (Exception e) {
			e.printStackTrace();

			log.info("operation failed exception message");

			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
		}
	}

	private ApiResponse<CustAccAppl> setTempReportingGls(CustAccAppl custAccAppl) {

		ReportingLinesMapping reportingLinesMapping = reportingLinesMappingRepository
				.findByModule(custAccAppl.getModule());

		if (reportingLinesMapping != null) {

			custAccAppl.getCaAccounts().get(0).setCrRepGl(reportingLinesMapping.getCrRepGl());

			custAccAppl.getCaAccounts().get(0).setDrRepGl(reportingLinesMapping.getDrRepGl());

			return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), custAccAppl);
		} else

		{
			return ApiResponse.failure(ResponseMessage.REPORTING_LINE_MAPPING_NOT_MAINTAINED.getMessage());
		}
	}

	public ApiResponse<List<LookupValues>> getApproverListByRoleIdService(String roleId) {

		log.info("get by Approver list by role Id method service is executed");

		try {
			List<UserRole> userRoleList = userRoleRepository.getByRoleId(roleId);

			if (userRoleList != null && userRoleList.size() > 0) {

				List<LookupValues> lookupValuesList = new LookupValues();

				for (UserRole userRole : userRoleList)
					;

				LookupValues lookupValues = new ArrayList<>();

				lookupValues.setId("1");

				lookupValues.setRoleName(UserRole.getRoleId());

				lookupValues.setRoleValue(UserRole.getRoleId());

				lookupValues.setRoleType(roleId);

				lookupValuesList.add(lookupValues);

			}
			return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), lookupValuesList);

			return ApiResponse.failure(ResponseMessage.NO_RECORDS_FOUND());

		} catch (Exception e) {
			e.printStackTrace();

			log.info("operation mesage exception");

			return ApiResponse.failure(ResponseMssage.OPERATIONED_FAILED);

		}

	}

	public ApiResponse<CustAccAppl> reject(String applicationNumber. String userRemark){
		
		log.info("reject method service is executed");
		
		JSONPObject jsonObjectForMaker =new JSONPObject();
		
		CustAccAppl custAccAppl=custAccApplRepository.getByApplicaionNumber(applicationNumber);
		
		try {
			
			if(!accessManagementService.checkUserAccess(Helper.getActiveUser.getName(),Function.CUSTOMERaCCOUNTAPPLICATION.getName(),
					EnumData.APPROVE_ACCESS.getMessage())) {
				
				return ApiResponse.failure(ResponseMessage.Access_not_available_for_approve_user.getMessage());
				
			}
			
			if(accessManagement.checkApprover(CustAccAppl.getCreatedBy)) {
				
				return ApiResponse.failure(ResponseMessage.MAKER_CANNOT_REJECT.getMessage());
			}
			
			List<String> userBranchAccess=utilUser.getActiveuserBranchAccess();
			
			if(!userBranchAccess.contains(custAccAppl.getAccountBranch()));
			
			log.info("user do not have access");
			
			return ApiResponse.failure(ResponseMesaage.ACCOUNT_REJECT_ACCESS_RESTRICTION.getMessage());
			
			custAccAppl.setApprovedBy(true);
			
			custAccAppl.setPendingApproval(false);
			
			
			custAccAppl.setApplicationStatus(EnumData.BRANCH_REJECTED.getName());
			
			custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApprovedBy());
			
			custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setPendingApproval());
			
			custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApplicationStatus(EnumData.Branch_rejected.getMessage()));
			
			
			custAccAppl.getCaAccounts().forEach(CaAccounts -> caAccounts.setApprovedBy());
			
			custAccAppl.getCaAccounts().forEach(CaAccounts -> caAccounts.setPEndingApproval());
			
			custAccAppl.getCaAccounts().forEach(CaAccounts -> caAccounts.setApplicationStatus(EnumData.BRANCH_REJECTED.getMesage()));
			
			CustAccAppl custAccApplication=custAccApplRepository.save(custAccAppl);
			
			ThreadUtil.executeInNewThread(() -> {
			try {
				workFlowNotification.sendcustAccApplRejectedNotification(custAccAppl);
				
			} catch (MessagingException e) {
				e.printStackTree();
			}log.error("failed to send the notification of rejected");
				
			});
			
			caAppEventService.caLogApplEvent(custAccAppl.getApplicationNumber(),EnumData.getBranch_rejected.getName(),
					EnumData.getAlert_rejected(), null, EnumData.rejected_action.getName(),userRemark);
			
			return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(),custAccApplication);
			
		} catch (Exception e) {
			
                    e.printStackTrace();
                    
                    return ApiResponse.failure(ResponseMessage.OPEARTION_FAILED.getMessage());
                    }
	}

	public ApiResponse<List<LookupValuesAll>> getApproverList() {

		List<Role> RoleList = roleRepository.getByRoleType("Approver");

		List<LookupValues> lookupValuesListAll = new ArrayList<>();

		for (Role role : roleList) {

			log.info("role :" + role.getRoleId());

			List<UserRole> userRoleList = userRoleRepository.getByRoleId(role.getByRoleId());

			for (UserRole userRole : userRoleList) {

				log.info("userId :" + userId.getUserId());

				if (userRole.getUserId != null) {

					log.info("getting user details");

					User user = userRepository.getByUserId(userRole.getRoleId());

					LookupValuesAll lookupValuesAll = new LookupValues();

					LookupValuesAll.setId("1");

					LookupValuesAll.setName(user.getFirstName() + "" + user.getLastName());

					LookupValuesAll.setValue(user.getUserId());

					LookupValuesAll.setType("approver");

					if (!lookupValuesListAll.contains(lookupValuesAll)) {

						log.info("adding user value");

						lookupValuesListAll.add(lookupValuesAll);
					}

				}

			}
		}
		return ApiResponse.Success(ResponseMessage.OPERATION_SUCCESS > getMessage(), lookupValuesListAll);
	}

	public ApiResponse<List<CaDocuments>> getDocumentDetailsService(String accountClass, String customerCategory,
			String custId) {

		log.info("in documents details service methid is executed");

		List<CaDocuments> caDocumentsFinalList = new ArrayList<>();

		try {

			DocChecklist dcDocCheckList = docCheckListRepository.findByAccountClassAndCustomerCategory(accountClass,
					CustomerCategory);

			List<CaDocuments> caDocumentsMaintenanceList = new ArrayList<>();

			if (dcDocCheckList != null) {

				List<DcDocDetails> dcDcDetailsList = dcDocCheckList.getDocumentCheckListDetails();

				for (DcDocDetails dcDocDetails : dcDocDetailsList) {

					List<DcDocTypes> dcDocTypesList = dcDocDetails.getDocumentTypeList();

					for (DcDocTypes dcDocTypes : dcDocTypesList) {

						CaDocuments caDocuments = new CaDocuments();

						caDocuments.setDocumentCategory(dcDocDetails.getDocumentCategory());

						caDocuments.setDocumentType(dcDocDetils.getDocumentType());

						caDocuments.setDocumentId(null);

						caDocuments.setMandatory(dcDocTypes.getMandatory());

						caDocumentsMaintenanceList.add(caDocuments);

						caDocumentsFinalList.add(caDocuments);

					}
				}
			}

			if (custId != null && !custId.isEmpty() && !custId.equals(null)) {

				caDocumentsFinalList.clear();

				List<CaDocuments> caDocumentsCustList = caDocumentsRepository.findByCustId(custId);

				boolean custDocumentFound = false;

				if (caDocumentsCustList != null && caDocumentsCustList.size() > 0) {

					for (CaDocuments caDocumentsMaitenance : caDocumentsMaintenanceList) {

						custDocumentFound = false;

						for (CaDocuments caDocumentsCust : caDocumentsCustList) {

							if (caDocumentsCust.getDocumentType().equals(caDocumentsMaintenanceList).getDocumentsType()

									&& (caDocumentsCust.getDocumentData() != null
											&& !caDocumentsCust.getDocumentData().isEmpty())) {

								if (!caDocumentsCust.getDocumentData().isEmpty()) {
									if (!caDocumentsFinalList.contains(caDocumentsCust))
										caDocumentsFinalList.add(caDocumentsCust);
									custDocumentFound = true;
								} else {
									if (!caDocumentsFinalList.contains(caDocumentsCust))
										caDocumentsFinalList.add(caDocumentsCust);
								}

								if (!custDocumentFound) {
									caDocumentsFinalList.add(caDocumentsMaintenance);
								}
							} else {
								caDocumentsFinalList = caDocumentsMaintenanceList;
							}
						}
						Comparator<CaDocuments> caDocumentsComparator = Comparator

								.comparing(CaDocuments::getDocumentId, Comparator.nullsLast(Comparator.naturalOrder()))

								.thenComparing(CaDocuments::getDocumentCategory)
								.thenComparing(CaDocuments::getDocumentType);

						caDocumentsFinalList = caDocumentsFinalList.stream().sorted(caDocumentsComparator)

								.collect(Collectors.toList());

						return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(),
								caDocumentsFinalList);
					}

				}
			}
			return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), caDocuments3);

		} catch (Exception e) {

			e.printStackTrace();

			log.error("In getdocumentdetailsService exception ", e);

			return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());

		}
	}

	public ApiResponse<CustAccAppl> approve(String applicationNumber, String userRemark, String hoAssignedTo) {
		
	
		log.info("In CustomerAccountApplication service approve method is executing");
		
		CustAccAppl custAccAppl = custAccApplRepository.getByApplicationNumber(applicationNumber);

		try {
			if (!accessManagementService.checkUserAccess(Helper.getActiveUser(),
					
					Function.CUSTOMERACCOUNTAPPLICATION.getName(), EnumData.APPROVE_ACCESS.getName())) {
				
				return ApiResponse.failure(ResponseMessage.ACCESS_NOT_AVAILABLE_FOR_APPROVE_ACCOUNT.getMessage());
		}
			if (accessManagementService.checkApprover(custAccAppl.getCreatedBy())) {
				return ApiResponse.failure(ResponseMessage.MAKER_CANNOT_APPROVE.getMessage());
			}
			
			List<String> userBranchAccess = userUtils.getActiveUserBranchAccess();
			
            if (!userBranchAccess.contains(custAccAppl.getAccountBranch())) {
            	
            }
                log.info("User do not have access. Returning failure");
                
                return ApiResponse.failure(ResponseMessage.ACCOUNT_APPROVE_ACCESS_RESTRICTION.getMessage());	
	}

		log.info("Record version :", custAccAppl.getRecordVersion());
		
		ApiResponse<CustAccAppl> custAccApplApiResponse = new ApiResponse<>();
		
		if (custAccAppl.getApplicationStatus().equals(ApplicationStatus.BRANCH_PENDING_APPROVAL.getName())
				
				&& custAccAppl.getApplicationAction().equals(ApplicationAction.CLOSE_ACTION.getName())) {
			
		}
			log.info("Close customer account in CBS");
			
			custAccApplApiResponse = bankingService.closeCustAccount(custAccAppl);
			
		}else if(custAccAppl.getApplicationStatus().equals(ApplicationStatus.BRANCH_PENDING_APPROVAL.getName())

	&&custAccAppl.getApplicationAction().equals(ApplicationAction.CREATE_ACTION.getName()))

	{

	}log.info("Create customer account in CBS");

	custAccApplApiResponse=bankingService.createCustomer(custAccAppl);

	}else if(custAccAppl.getApplicationStatus().equals(ApplicationStatus.BRANCH_PENDING_APPROVAL.getName())

	&&custAccAppl.getApplicationAction().equals(ApplicationAction.UPDATE_ACTION.getName())){

	log.info("Update customer account in CBS");

	custAccApplApiResponse=bankingService.brApproveUpdateCustomer(custAccAppl);}

	ObjectMapper mapper = new ObjectMapper();

	log.info("CBS response status "+custAccApplApiResponse.getStatus());

	if(custAccApplApiResponse.getStatus()==0)
	{
		CustAccAppl custAccApplResponse = mapper.convertValue(custAccApplApiResponse.getData(), CustAccAppl.class);

		custAccApplRepository.save(custAccApplResponse);

		if (custAccAppl.getApplicationAction().equals(ApplicationAction.UPDATE_ACTION.getName())) {

			return ApiResponse.failure("Failed to update customer in Flexcube", custAccApplResponse);

		} else if (custAccAppl.getApplicationAction().equals(ApplicationAction.CLOSE_ACTION.getName())) {

			return ApiResponse.failure("Failed to close customer in Flexcube", custAccApplResponse);

		} else if (custAccAppl.getApplicationAction().equals(ApplicationAction.CREATE_ACTION.getName())) {

			return ApiResponse.failure("Failed to create/modify customer in Flexcube", custAccApplResponse);
		}

		return ApiResponse.failure("Failed to process application in FLexcube", custAccApplResponse);

	}else
	{

		log.info("log the application event");

		caApplEventsService.logCaApplEvent(custAccAppl.getApplicationNumber(),

				EnumData.KYC_PENDING_APPROVAL.getName(), EnumData.USER_ALERT_APPROVED.getName(), hoAssignedTo,

				EnumData.APPROVE_ACTION.getName(), userRemark);

		CustAccAppl custAccApplResponse = mapper.convertValue(custAccApplApiResponse.getData(),

				CustAccAppl.class);

		custAccApplResponse.setHoAssignedTo(hoAssignedTo);
		custAccApplResponse.setApproved(true);
		custAccApplResponse.setPendingApproval(false);
		custAccApplResponse.setApprovedBy(Helper.getActiveUser());
		custAccApplResponse.setApprovedDate(Helper.getCurrentDateAndTime());
		custAccApplResponse.setApplicationStatus(EnumData.KYC_PENDING_APPROVAL.getName());

		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setHoAssignedTo(hoAssignedTo));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApproved(true));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setPendingApproval(false));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApprovedBy(Helper.getActiveUser()));
		custAccAppl.getCaDetails().forEach(caDetails -> caDetails.setApprovedDate(Helper.getCurrentDateAndTime()));
		custAccAppl.getCaDetails()
				.forEach(caDetails -> caDetails.setApplicationStatus(EnumData.KYC_PENDING_APPROVAL.getName()));

		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setHoAssignedTo(hoAssignedTo));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setApproved(true));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setPendingApproval(false));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setApprovedBy(Helper.getActiveUser()));
		custAccAppl.getCaAccounts().forEach(caAccounts -> caAccounts.setApprovedDate(Helper.getCurrentDateAndTime()));
		custAccAppl.getCaAccounts()
				.forEach(caAccounts -> caAccounts.setApplicationStatus(EnumData.KYC_PENDING_APPROVAL.getName()));

		CustAccAppl custAccApplFrmDb = custAccApplRepository.save(custAccApplResponse);
		log.error("Sending workflow notification for application approval");
		ThreadUtil.executeInNewThread(() -> {
			try {
				workFlowNotification.sendCustAccApplBranchApprovedNotification(custAccApplFrmDb);
			} catch (MessagingException e) {
				log.error("Failed to send workflow notification for application approval", e);
			}
		});
		log.error("Returning success from approve");
		return ApiResponse.success(ResponseMessage.CUSTACCAPPL_BRAPPROVED_SUCCESS.getMessage(), custAccApplFrmDb);
	}catch(
	Exception e)
	{
		e.printStackTrace();

		log.error("In exception when approving ", e);
		return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
	}
}

public ApiResponse<CustAccAppl> saveApplicationAsDraftService(CustAccAppl custAccAppl) {
	
	log.info("In saveApplicationAsDraftService method");
	
	try {
		if (!custAccAppl.getApplicationNumber().equals("")) {
			
		}
			CustAccAppl custAccApplFromDb = custAccApplRepository.getByApplicationNumber(custAccAppl.getApplicationNumber());
			
			List<CaAccounts> caAccountsList = new ArrayList<CaAccounts>();
			
			if (custAccApplFromDb.getCaAccounts().size() > 0) {
				
			}
				for (CaAccounts caAccount : custAccAppl.getCaAccounts()) {

					caAccount.setApplicationNumber(custAccApplFromDb.getApplicationNumber());
					
					caAccount.setAccId(custAccApplFromDb.getCaAccounts().get(0).getAccId());
					
					caAccountsList.add(caAccount);
				}
				custAccAppl.setCaAccounts(caAccountsList);
			
	List<CaDetails> caDetailsList = new ArrayList<CaDetails>();
	
	List<CaImages> caImagesList = new ArrayList<CaImages>();
	
	List<CaDocuments> caDocumentsList = new ArrayList<CaDocuments>();

	if (custAccApplFromDb.getCaDetails().size() > 0) {
		
	}
		for (CaDetails caDetails : custAccAppl.getCaDetails()) {
			
		}
			caDetails.setApplicationNumber(custAccApplFromDb.getApplicationNumber());
			
			caDetails.setCustId(custAccApplFromDb.getCaDetails().get(0).getCustId());
			
			if (caDetails.getCaImages().size() > 0) {
				
			}
				for (CaImages caImages : caDetails.getCaImages()) {
					
					caImages.setCustId(custAccApplFromDb.getCaDetails().get(0).getCustId());
					
					caImagesList.add(caImages);
				}

	
	if (caDetails.getCaDocuments().size() > 0) {
		
		for (CaDocuments caDocuments : caDetails.getCaDocuments()) {
			
			caDocuments.setCustId(custAccApplFromDb.getCaDetails().get(0).getCustId());
			
			caDocumentsList.add(caDocuments);
		}
	}
	caDetails.setCaImages(caImagesList);
	
	caDetails.setCaDocuments(caDocumentsList);
	
	caDetailsList.add(caDetails);
	
}custAccAppl.setCaDetails(caDetailsList);

}

	int recordVersion = custAccApplFromDb.getRecordVersion()

			+ 1;custAccAppl.setRecordVersion(recordVersion);custAccAppl.setCreatedDate(custAccApplFromDb.getCreatedDate());custAccAppl.setCreatedBy(custAccApplFromDb.getCreatedBy());custAccAppl.setLastUpdatedBy(Helper.getActiveUser());custAccAppl.setLastUpdatedDate(Helper.getCurrentDateAndTime());custAccAppl.setApplicationDate((Helper.formattingDate(Helper.getCurrentDateAndTime())));
	List<CaDetails> caDetailsLists = new ArrayList<>();for(
	CaDetails caDetails:custAccAppl.getCaDetails())
	{
		CaDetailsPersonal caDetailsPersonal = caDetailsPersonalRepository.save(caDetails.getCaDetailsPersonals());
		caDetails.getCaDetailsCorporates().setCustId(caDetailsPersonal.getCustId());
		caDetails.getCaAdditionalFields().setCustId(caDetailsPersonal.getCustId());
		caDetails.setCustId(caDetailsPersonal.getCustId());
		caDetailsLists.add(caDetails);
	}
	int recordVersions = custAccApplFromDb.getRecordVersion()
			+ 1;custAccAppl.setRecordVersion(recordVersion);custAccAppl.setCreatedDate(custAccApplFromDb.getCreatedDate());custAccAppl.setCreatedBy(custAccApplFromDb.getCreatedBy());custAccAppl.setLastUpdatedBy(Helper.getActiveUser());custAccAppl.setLastUpdatedDate(Helper.getCurrentDateAndTime());custAccAppl.setApplicationDate((Helper.formattingDate(Helper.getCurrentDateAndTime())));
	List<CaDetails> caDetailsLists = new ArrayList<>();for(
	CaDetails caDetails2:custAccAppl.getCaDetails())
	{
		CaDetailsPersonal caDetailsPersonal = caDetailsPersonalRepository.save(caDetails.getCaDetailsPersonals());
		caDetails.getCaDetailsCorporates().setCustId(caDetailsPersonal.getCustId());
		caDetails.getCaAdditionalFields().setCustId(caDetailsPersonal.getCustId());
		caDetails.setCustId(caDetailsPersonal.getCustId());
		caDetailsLists.add(caDetails);
	}custAccAppl.setCaDetails(caDetailsLists);custAccApplRepository.save(custAccAppl);return ApiResponse.success(ResponseMessage.APPLICATION_SAVED_AS_DRAFT.getMessage(),custAccAppl);}else{custAccAppl.setApproved(false);
	int recordVersion = 1;custAccAppl.setRecordVersion(recordVersion);custAccAppl.setCreatedBy(Helper.getActiveUser());custAccAppl.setCreatedDate(Helper.getCurrentDateAndTime());custAccAppl.setRecordStatus(EnumData.INACTIVE.getName());custAccAppl.setLastUpdatedBy(null);custAccAppl.setLastUpdatedDate(null);custAccAppl.setApplicationStatus(EnumData.BRANCH_SAVE_DRAFT.getName());custAccAppl.setPendingApproval(true);custAccAppl.setApplicationDate((Helper.formattingDate(Helper.getCurrentDateAndTime())));custAccAppl.setApplicationNumber(commonService.generateApplicationNumber("ACCOUNT"));
	List<CaDetails> caDetailsList = new ArrayList<>();for(
	CaDetails caDetails1:custAccAppl.getCaDetails())
	{
		CaDetailsPersonal caDetailsPersonal = caDetailsPersonalRepository.save(caDetails.getCaDetailsPersonals());
		caDetails.getCaDetailsCorporates().setCustId(caDetailsPersonal.getCustId());
		caDetails.getCaAdditionalFields().setCustId(caDetailsPersonal.getCustId());
		caDetails.setCustId(caDetailsPersonal.getCustId());
		caDetailsList.add(caDetails);
	}custAccAppl.setCaDetails(caDetailsList);custAccApplRepository.save(custAccAppl);return ApiResponse.success(ResponseMessage.APPLICATION_SAVED_AS_DRAFT.getMessage(),custAccAppl);}

	}catch(
	Exception e)
	{
log.error("In saveApplicationAsDraftService method exception ----->" + e);
return ApiResponse.failure(ResponseMessage.OPERATION_FAILED.getMessage());
}

}

}
