package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.repository.CertificateAgencyRepository;
import com.trustrace.assignment.scm.service.CertificateAgencyService;

@Service
public class CertificateAgencyServiceImp implements CertificateAgencyService {
	
	@Autowired
	CertificateAgencyRepository certificateAgencyRepo;
	
	
	public CertificateAgency getById(String id){
		return certificateAgencyRepo.findById(id).get();
	}
	
	public String saveAgency(CertificateAgency a) {
		certificateAgencyRepo.save(a);
		return "Agency saved Successfully id: "+a.get_id();
	}
	
	public void updateAgency(CertificateAgency a) {
		certificateAgencyRepo.save(a);
	}
	
	public void deleteAgency(String id) {
		certificateAgencyRepo.deleteById(id);
	}
	
	@Override
	public List<CertificateAgency> getAllAgency() {
		return certificateAgencyRepo.findAll();
	}
	
}
