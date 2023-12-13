package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.CertificateAgency;

public interface CertificateAgencyService 
{
	
	List<CertificateAgency> getAllAgency();
	
	CertificateAgency getById(String _id);
	
	String saveAgency(CertificateAgency a);
	
	String updateAgency(CertificateAgency a);
	
	String deleteAgency(String _id);
	
}
