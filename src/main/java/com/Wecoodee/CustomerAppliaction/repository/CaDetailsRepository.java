package com.Wecoodee.CustomerAppliaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Wecoodee.CustomerAppliaction.model.CaDetails;

@Repository
public interface CaDetailsRepository extends JpaRepository<CaDetails, String> {
	CaDetails findByCustId(String custId);

}
