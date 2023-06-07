package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.EligibilityDetails;

public interface EligibilityRepository extends JpaRepository<EligibilityDetails, Integer> {

	@Query("SELECT DISTINCT plan_name FROM EligibilityDetails")
    public List<String> findDistinctPlanName();
	
	@Query("SELECT DISTINCT plan_status FROM EligibilityDetails")
	public List<String> findDistinctPlanStatus();
	
	
}
