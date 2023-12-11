package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.CertificateDetails;

public interface CertificateDetailsService {
	
	List<CertificateDetails> getAllData();
	
	CertificateDetails getById(String _id);
	
	String saveData(CertificateDetails a);
	
	void update(CertificateDetails a);
	
	void delete(String _id);
}
