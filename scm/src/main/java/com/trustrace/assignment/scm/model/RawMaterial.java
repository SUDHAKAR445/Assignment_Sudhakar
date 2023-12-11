package com.trustrace.assignment.scm.model;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rawMaterial")
public class RawMaterial {
    @Id
    private String _id;

    @Field("name")
    private String name;

    @Field("supplierID")
    private String supplierID;

    @Field("quantity")
    private String quantity;

    @Field("unit")
    private String unit;

    @Field("timeStamp")
    private Date timeStamp;
}
