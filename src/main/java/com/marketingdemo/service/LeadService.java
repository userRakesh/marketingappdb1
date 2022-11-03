package com.marketingdemo.service;

import java.util.List;

import com.marketingdemo.entity.Lead;

public interface LeadService {
public void saveLead(Lead lead);

public List<Lead> getLeads();

public void deleteOneLead(long id);

public Lead findOneLead(long id); 
}
