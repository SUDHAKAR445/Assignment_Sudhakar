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
	
	
	public List<CertificateDetails> getAllCertificate(){
		List<CertificateDetails> list = new ArrayList<>();
		list = certificateDetailsRepo.findAll();
		return list;
	}
	
	public CertificateDetails getById(String id){
		return certificateDetailsRepo.findById(id).get();
	}
	
	public String saveCertificate(CertificateDetails a) {
		if(certificateDetailsRepo.existsById(a.get_id()))
		{
			return "Certificate id allready exists";
		}
		certificateDetailsRepo.save(a);
		return "Certificate saved Successfully id: ";
	}
	
	public String updateCertificate(CertificateDetails a) {
		if(!certificateDetailsRepo.existsById(a.get_id()))
		{
			return "Certificate id doesn't exists";
		}
		certificateDetailsRepo.save(a);
		return "Certificate updated successfully";
	}
	
	public String deleteCertificate(String id) {
		if(!certificateDetailsRepo.existsById(id))
		{
			return "Certificate id doesn't exists";
		}
		certificateDetailsRepo.deleteById(id);
		return "Certficate deleted successfully";
	}

	
}
