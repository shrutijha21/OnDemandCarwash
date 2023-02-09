package com.cap.adminservicecar.controller;


import com.cap.adminservicecar.models.WashPack;
import com.cap.adminservicecar.models.WasherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/wash")
public class WasherController {

    @Autowired
    private RestTemplate restTemplate;

    String washpackUrl= "http://localhost:8081/washpack/";

    String washerUrl= "http://localhost:8081/washer/";

    @PostMapping("/add")
    public WasherInfo insertWasherInfo(@RequestBody WasherInfo washerInfo){

        //sending the RequestBody
        RequestEntity<WasherInfo> request = RequestEntity
                .post(washerUrl+"add")
                .accept(MediaType.APPLICATION_JSON)
                .body(washerInfo);
        ResponseEntity<WasherInfo> response = restTemplate.exchange(request, WasherInfo.class);
        WasherInfo wI=response.getBody();
        return wI;

       //return restTemplate.getForObject(washerUrl+"add", WasherInfo.class);
    }

    @GetMapping("/view")
    public WasherInfo[] getAllWashers(){
        ResponseEntity<WasherInfo[]> response=restTemplate.getForEntity(washerUrl+"view", WasherInfo[].class);
        WasherInfo[] wI=response.getBody();
        return wI;
    }



    @PutMapping("/update/{id}")
    public WasherInfo updateWasherInfo(@RequestBody WasherInfo washerInfo, @PathVariable("id") int washerId)
    {
        RequestEntity<WasherInfo> request = RequestEntity
                .put(washerUrl+"update/"+washerId)
                .accept(MediaType.APPLICATION_JSON)
                .body(washerInfo);
        ResponseEntity<WasherInfo> response = restTemplate.exchange(request, WasherInfo.class);
        WasherInfo wI=response.getBody();
        return wI;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteWasherInfo(@PathVariable("id") int washerId)
    {
         restTemplate.delete(washerUrl+"delete/" + washerId);
    }

    //Getting wash pack details

    @GetMapping("/viewall")
    public WashPack[] getWashPacks(){
        ResponseEntity<WashPack[]> response =restTemplate.getForEntity(washpackUrl+"viewall", WashPack[].class);
        WashPack[]  washPacks= response.getBody();
        return (washPacks);

    }

    @GetMapping("/view/{name}")
    public WashPack getWashPackByName(@PathVariable("name") String washPackName){
        return restTemplate.getForObject(washpackUrl+"view/" + washPackName,WashPack.class);

    }

}
