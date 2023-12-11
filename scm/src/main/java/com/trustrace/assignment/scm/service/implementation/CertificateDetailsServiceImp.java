package com.trustrace.assignment.scm.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.CertificateDetails;
import com.trustrace.assignment.scm.repository.CertificateDetailsRepository;
import com.trustrace.assignment.scm.service.CertificateDetailsService;

@Service
public class CertificateDetailsServiceImp implements CertificateDetailsService{
	
	@Autowired
	CertificateDetailsRepository certificateDetailsRepo;
	
	
	public List<CertificateDetails> getAllData(){
		List<CertificateDetails> list = new ArrayList<>();
		list = certificateDetailsRepo.findAll();
		return list;
	}
	
	public CertificateDetails getById(String id){
		return certificateDetailsRepo.findById(id).get();
	}
	
	public String saveData(CertificateDetails a) {
		certificateDetailsRepo.save(a);
		return "Certificate saved Successfully id: ";
	}
	
	public void update(CertificateDetails a) {
		certificateDetailsRepo.save(a);
	}
	
	public void delete(String id) {
		certificateDetailsRepo.deleteById(id);
	}
	
}
