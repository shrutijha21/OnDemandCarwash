package com.cap.customerservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customerInfo")
public class CustomerInfo {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int customerId;
    @NotBlank(message = "name must not be null or empty")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String customerName;
    @Email(message = "not a valid email")
    private String customerEmail;
    @NotBlank(message = "password is required")
    @Size(min = 4, max = 10)
    private String customerPassword;
    @NotBlank(message = "address is required")
    private String customerAddress;

}
