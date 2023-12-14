package com.trustrace.assignment.scm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Production {
    @Id
    private String _id;

    @Field("productionID")
    private String productionID;
    
    @Field("product")
    private String product;

    @Field("quantityProduced")
    private String quantityProduced;

    @Field("buyerID")
    @DocumentReference(collection = "account")
    private Account buyerID;

    @Field("timestamp")
    private Date timestamp;
}
