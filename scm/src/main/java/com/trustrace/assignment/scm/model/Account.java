package com.trustrace.assignment.scm.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="account")
public class Account{
	public static final String HttpStatus = null;

	@Id
	private String _id;
	
	@Field("brandid")
	private String brandid;

	@Field("name")
	private String name;
	
	@Field("type")
	private String type;
	
	@Field("tier")
	private String tier;
	
	@Field("productName")
	private String productName;
	
	@Field("sustainabilityRating")
	private Integer sustainabilityRating;
	
	@Field("countryOrigin")
	private String countryOrigin;
	
	@Field("certifictaions")
	@DocumentReference(collection = "certificateDetails")
	private ArrayList<CertificateDetails> certifications;
	
	@Field("contact")
	private Supp contact;
	
	@Field("supplier")
	@DocumentReference(collection = "supplier")
	private ArrayList<String> supplier;
	
	@Field("brand")
	@DocumentReference(collection = "account")
	private ArrayList<Account> brand;
	
	@Field("productCategories")
	private ArrayList<String> productCategories;	
		
	@Data	 
	@AllArgsConstructor
	@NoArgsConstructor
	class Supp
	{
		String street;
		String city;
		String state;
		String phone;
	}
}
