package com.cap.adminservicecar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document("washPack")
public class WashPack {

    @Id
    private String washPackId;
    private String washPackName;
    private String washPackDescription;
    private int washPackCost;
}
