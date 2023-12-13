package com.trustrace.assignment.scm.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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

    @Field("product")
    private String product;

    @Field("quantityProduced")
    private String quantityProduced;

    @Field("buyerID")
    private ObjectId buyerID;

    @Field("timestamp")
    private Date timestamp;
}
