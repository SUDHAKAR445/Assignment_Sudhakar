package com.trustrace.assignment.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.model.CertificateDetails;
import com.trustrace.assignment.scm.service.CertificateDetailsService;

@RestController
//base url
@RequestMapping("/certificatedetails/")
public class CertificateDetailsController {
	@Autowired
	CertificateDetailsService certificateDetailsService;
	
	@GetMapping("/select")
	public List<CertificateDetails> getAllCertificateDetails(){
		return certificateDetailsService.getAllData();
	}
	
	@GetMapping("/select/certificatebyid/{id}")
	public CertificateDetails getById(@PathVariable("id") String id){
		return certificateDetailsService.getById(id);
		
	}
	
	@PostMapping("/save")
	public String insert(@RequestBody CertificateDetails a) {
		certificateDetailsService.saveData(a);
		return "Inserted Successfully";
	}
	
	@PutMapping("/update")
	public String update(@RequestBody CertificateDetails a) {
		certificateDetailsService.update(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/certificatebyid/{id}")
	public String delete(@PathVariable("id") String id) {
		certificateDetailsService.delete(id);
		return "Deleted Successfully";
	}
}
