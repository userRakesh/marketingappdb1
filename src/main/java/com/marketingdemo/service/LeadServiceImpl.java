package com.marketingdemo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingdemo.entity.Lead;
import com.marketingdemo.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
@Autowired
private LeadRepository leadRepo;
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}
	@Override
	public List<Lead> getLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
	}
	@Override
	public Lead findOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
