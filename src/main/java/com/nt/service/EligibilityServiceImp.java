package com.nt.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.binding.FilterModel;
import com.nt.entity.EligibilityDetails;
import com.nt.repo.EligibilityRepository;
import com.nt.reponse.ResponseDetails;

@Service
public class EligibilityServiceImp implements IEligibilityService {

	@Autowired
	private EligibilityRepository repo;

	@Override
	public String registerEntry(EligibilityDetails details) {
		repo.save(details);
		return "registered successfully";
	}

	@Override
	public List<EligibilityDetails> getAllEntries() {
		List<EligibilityDetails> list = repo.findAll();

		return list;
	}

	@Override
	public List<ResponseDetails> getDataWithOrWithoutFilter(FilterModel model) {
		List<EligibilityDetails> allrecords = new ArrayList<EligibilityDetails>();
		if (requestData(model)) {
			 allrecords = repo.findAll();
			

		} else {
			String planName = model.getPlanName();
			String planStatus = model.getPlanStatus();
			LocalDate startDate = model.getStartDate();
			LocalDate endDate = model.getEndDate();

			EligibilityDetails entity = new EligibilityDetails();

			if (planName != null && !planName.equals("")) {
				entity.setPlan_name(planName);
			}
			if (planStatus != null && !planName.equals("")) {
				entity.setPlan_status(planStatus);
			}
			if (startDate != null & endDate != null) {
				entity.setStart_date(startDate);
				entity.setEnd_date(endDate);
			}
			Example<EligibilityDetails> of = Example.of(entity); // adding in where clause
			allrecords = repo.findAll(of);
		}
		List<ResponseDetails> response = new ArrayList<>();
		for (EligibilityDetails eligRecord : allrecords) {
			ResponseDetails sr = new ResponseDetails();
			BeanUtils.copyProperties(eligRecord, sr);
			response.add(sr);
		}

		return response;
	}
	
	private boolean requestData(FilterModel model) {
		boolean isEmpty=true;
		
		if(model.getPlanName()!=null && model.getPlanName().equals("")) {
			return false;
		}
		if(model.getPlanStatus()!=null && model.getPlanStatus().equals("")) {
			return false;
		}
		if(model.getStartDate()!=null && model.getStartDate().equals("")) {
			return false;
		}
		return isEmpty;
	}

	@Override
	public List<String> getAllPlanName() {
		return repo.findDistinctPlanName();

	}

	@Override
	public List<String> getAllPlanStatus() {
		return repo.findDistinctPlanStatus();
	}
}
