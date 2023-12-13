package com.trustrace.assignment.scm.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="account")
public class Account{
	@Id
	private String _id;
	
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
	private ArrayList<ObjectId> certifications;
	
	@Field("contact")
	private Supp contact;
	
	@Field("supplier")
	private ArrayList<ObjectId> supplier;
	
	@Field("brand")
	private ArrayList<ObjectId> brand;
	
	@Field("productCategories")
	private ArrayList<String> productCategories;	
	
	// @Data	 
	// @NoArgsConstructor
	// @AllArgsConstructor
	// public class cert
	// {
	// 	String certificateId;
	// }
	
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
