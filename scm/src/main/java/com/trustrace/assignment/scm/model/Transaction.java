package com.trustrace.assignment.scm.model;

import java.util.ArrayList;
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
public class Transaction {
    @Id
    private String _id;

    @Field("product")
    private String product;

    @Field("quantity")
    private String quantity;

    @Field("sellerID")
    private ObjectId sellerID;

    @Field("buyerID")
    private ObjectId buyerID;

    @Field("shipdate")
    private Date shipDate;

    @Field("arrivalDate")
    private Date arrivalDate;

    @Field("orderID")
    private ObjectId orderID;

    @Field("rawMaterialReference")
    private ArrayList<ObjectId> rawMaterialReference;

    @Field("productionReference")
    private ArrayList<ObjectId> productionReference;
}
