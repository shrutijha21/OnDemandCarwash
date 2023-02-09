package com.cap.adminservicecar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
//@Document(collection = "washerInfo")
public class WasherInfo {

//    @Transient
//    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int washerId;
    private String washerName;
    private String washerEmail;
    private String washerPassword;



}
