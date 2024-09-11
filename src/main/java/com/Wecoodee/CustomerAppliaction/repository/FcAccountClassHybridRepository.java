package com.Wecoodee.CustomerAppliaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Wecoodee.CustomerAppliaction.model.FcAccountClassHybrid;

@Repository
public interface FcAccountClassHybridRepository extends JpaRepository<FcAccountClassHybrid, String> {

}
