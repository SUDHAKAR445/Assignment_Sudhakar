package com.trustrace.assignment.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
		try{
			return new ResponseEntity<List<CertificateAgency>>(certificateAgencyService.getAllAgency(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/agencybyid/{id}")
	public ResponseEntity<CertificateAgency> getById(@PathVariable("id") String id){
		try{
			return new ResponseEntity<CertificateAgency>(certificateAgencyService.getById(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createAgency(@RequestBody CertificateAgency account)
	{
		try{
			return new ResponseEntity<String>(certificateAgencyService.saveAgency(account),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody CertificateAgency a) {
		try{
			return new ResponseEntity<>(certificateAgencyService.updateAgency(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/agencybyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<>(certificateAgencyService.deleteAgency(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
}
