package com.cap.customerservice.controller;

import com.cap.customerservice.model.WashPack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/wash")
public class WasherController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/viewall")
    public WashPack[] getWashPacks(){
        ResponseEntity<WashPack[]> response =restTemplate.getForEntity("http://localhost:8081/washpack/viewall", WashPack[].class);
        WashPack[]  washPacks= response.getBody();
        return (washPacks);

    }

    @GetMapping("/view/{name}")
    public WashPack getWashPackByName(@PathVariable("name") String washPackName){
        return restTemplate.getForObject("http://localhost:8081/washpack/view/" + washPackName,WashPack.class);

    }
}
