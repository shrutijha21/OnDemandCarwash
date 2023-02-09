package com.cap.washer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "washerInfo")
public class WasherInfo {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int washerId;
    @NotBlank(message = "name must not be null or empty")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String washerName;
    @Email(message = "not a valid email")
    private String washerEmail;
    @NotBlank(message = "password is required")
    @Size(min = 4, max = 10)
    private String washerPassword;



}
