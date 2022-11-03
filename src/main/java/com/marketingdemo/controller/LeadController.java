package com.marketingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingdemo.entity.Lead;
import com.marketingdemo.service.LeadService;
import com.marketingdemo.utilities.EmailService;

@Controller
public class LeadController {
@Autowired
private EmailService emailService;
@Autowired
private LeadService leadService;
@RequestMapping(value = "/viewCreateLeadPage",method =RequestMethod.GET)
public String viewCreateLeadPage() {
	return "create_lead";
}
		@RequestMapping("/saveLead")
		public String saveOneLead(@ModelAttribute("lead") Lead lead , ModelMap model) {
			emailService.sendEmail(lead.getEmail(),"welcome","we have recieved enquiry");

			leadService.saveLead(lead);
			model.addAttribute("msg","Lead is saved!!");
				return "create_lead";
}
	@RequestMapping("/listall")
	public String getAllLeads(ModelMap model) {
    List<Lead> leads = leadService.getLeads();
    model.addAttribute("leads",leads);

		return "lead_search_results";
		}
	
	
@RequestMapping("/delete")
public String deleteOneLeadById(@RequestParam("id") long id,ModelMap model) {
	leadService.deleteOneLead(id);
	List<Lead> leads = leadService.getLeads();
	model.addAttribute("leads", leads);
	model.addAttribute("msg1","your lead is deleted");

	return "lead_search_results";
}

@RequestMapping("/update")
public String updateOneLead(@RequestParam("id") long id, ModelMap model) {
	Lead lead = leadService.findOneLead(id);
	model.addAttribute("lead", lead);
	return"update_lead";
}
@RequestMapping("/updateLead")
public String updateLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
	leadService.saveLead(lead);
	model.addAttribute("msg2", "Lead with id:" + lead.getId() + "is updated");
	List<Lead> leads  = leadService.getLeads();
	model.addAttribute("leads",leads);
	return "lead_search_results";
}


///*@RequestMapping("/saveLead")
//public String saveOneLead(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("email") String email, @RequestParam("mobile") long mobile) {
//	Lead l = new Lead();
//	l.setFirstname(firstname);
//	l.setLastname(lastname);
//	l.setEmail(email);
//	l.setMobile(mobile);
//	
//	leadService.saveLead(l);
//	return "create_lead";
//}*/


//@RequestMapping("/saveLead")
//public String saveOneLead(LeadData data, Model model) {
//	Lead l = new Lead();
//	l.setFirstname(data.getFirstname());
//	l.setLastname(data.getLastname());
//	l.setEmail(data.getEmail());
//	 l.setMobile(data.getMobile());
//	model.addAttribute("msg", "Lead is saved!!");
//	
//	leadService.saveLead(l);
//	return "create_lead";	
//}
}
