package com.nt.service;

import java.util.List;

import com.nt.binding.FilterModel;
import com.nt.entity.EligibilityDetails;
import com.nt.reponse.ResponseDetails;

public interface IEligibilityService {

	public List<String> getAllPlanName();
	public List<String> getAllPlanStatus();
	public String registerEntry(EligibilityDetails details);
	public List<EligibilityDetails> getAllEntries();
	public List<ResponseDetails> getDataWithOrWithoutFilter(FilterModel model);
	
}
