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
		if(certificateAgencyRepo.existsById(a.get_id()))
		{
			return "Certificate id allready exists";
		}
		certificateAgencyRepo.save(a);
		return "Agency saved Successfully id: "+a.get_id();
	}
	
	public String updateAgency(CertificateAgency a) {
		if(!certificateAgencyRepo.existsById(a.get_id()))
		{
			return "Certificate id doesn't exists";
		}
		certificateAgencyRepo.save(a);
		return "Updated successfully";
	}
	
	public String deleteAgency(String id) {
		if(!certificateAgencyRepo.existsById(id))
		{
			return "Certificate id doesn't exists";
		}
		certificateAgencyRepo.deleteById(id);
		return "Deleted successfully";
	}
	
@Override
	public List<CertificateAgency> getAllAgency() {
		return certificateAgencyRepo.findAll();
	}
	
}
