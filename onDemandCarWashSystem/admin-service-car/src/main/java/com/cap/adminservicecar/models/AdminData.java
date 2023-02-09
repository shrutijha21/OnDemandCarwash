package com.cap.adminservicecar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "adminData")
public class AdminData {


    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int adminId;
    private String userName;//email
    private String password;
}
