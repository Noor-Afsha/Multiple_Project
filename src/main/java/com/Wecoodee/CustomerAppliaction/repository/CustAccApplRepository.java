package com.Wecoodee.CustomerAppliaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Wecoodee.CustomerAppliaction.model.CustAccAppl;

@Repository
public interface CustAccApplRepository extends JpaRepository<CustAccAppl, String> {

	CustAccAppl getByApplicaionNumber(String applicationNumber);

	int deleteByAppliactionNumber(String applicationNumber);
}
