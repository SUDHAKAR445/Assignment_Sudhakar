package com.trustrace.assignment.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.service.CertificateAgencyService;

@RestController
//base url
@RequestMapping("/agency/")
public class CertificateAgencyController {
	@Autowired
	CertificateAgencyService certificateAgencyService;
	
	@GetMapping("/getallagency")
	public ResponseEntity<List<CertificateAgency>> readAllAgency()
	{
		return new ResponseEntity<List<CertificateAgency>>(certificateAgencyService.getAllAgency(),HttpStatus.OK);
	}
	
	@GetMapping("/select/agencybyid/{id}")
	public CertificateAgency getById(@PathVariable("id") String id){
		return certificateAgencyService.getById(id);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createAgency(@RequestBody CertificateAgency account)
	{
		return new ResponseEntity<String>(certificateAgencyService.saveAgency(account),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody CertificateAgency a) {
		certificateAgencyService.updateAgency(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/agencybyid/{id}")
	public String delete(@PathVariable("id") String id) {
		certificateAgencyService.deleteAgency(id);
		return "Deleted Successfully";
	}
	
}
