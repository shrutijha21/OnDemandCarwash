package com.cap.adminservicecar.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "customerInfo")
public class CustomerInfo {

//    @Transient
//    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerAddress;

}
