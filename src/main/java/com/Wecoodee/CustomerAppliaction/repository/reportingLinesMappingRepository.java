package com.Wecoodee.CustomerAppliaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Wecoodee.CustomerAppliaction.model.CustAccAppl;

@Repository
public interface reportingLinesMappingRepository extends JpaRepository<CustAccAppl, String> {

	reportingLinesMappingRepository findByModule(String module);

}
