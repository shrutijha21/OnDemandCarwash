package com.cap.washer.controller;


import com.cap.washer.models.WashPack;
import com.cap.washer.repository.WashPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/washpack")
public class WashPackController {

    @Autowired
    WashPackRepository washPackRepository;

    @RequestMapping("/viewall")
    public ResponseEntity<List<WashPack>> getAllWashPacks()
    {

        List<WashPack> list= washPackRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/view/{name}")
    public  WashPack getWashPackByName(@PathVariable("name") String washPackName)
    {
        return washPackRepository.findByWashPackName(washPackName);
    }


}
