package com.cap.washer.controller;


import com.cap.washer.models.WasherInfo;
import com.cap.washer.services.SequenceGeneratorService;
import com.cap.washer.services.WasherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/washer")
public class WasherInfoController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    WasherInfoService washerInfoService;

    @RequestMapping("/")
    public String getWasher(){
        return "hii washer";
    }

    @Validated
    @PostMapping("/add")
    public WasherInfo insertWasherInfo(@RequestBody @Valid WasherInfo washerInfo){
//        washerInfo.setWasherId(sequenceGeneratorService.getSequenceNumber(WasherInfo.SEQUENCE_NAME));
        return washerInfoService.insertWasherInfo(washerInfo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasherInfo> getById(@PathVariable("id") int id){
        WasherInfo wI=washerInfoService.getById(id);
        return ResponseEntity.ok(wI);
    }

    @GetMapping("/view")
    public List<WasherInfo> getAllWashers(){
        return washerInfoService.getAllWashers();
    }

    @GetMapping("/view/{email}")
    public WasherInfo getByWasherEmail(@PathVariable("email") String washerEmail){
        return washerInfoService.findByWasherEmail(washerEmail);
    }

    @Validated
    @PutMapping("/update/{id}")
    public WasherInfo updateWasherInfo(@RequestBody @Valid WasherInfo washerInfo, @PathVariable("id") int washerId)
    {
        return washerInfoService.updateWasherInfo(washerInfo, washerId);

    }


    @DeleteMapping("/delete/{id}")
    public void deleteWasherInfo(@PathVariable("id") int userId)
    {
        washerInfoService.deleteWasherInfo(userId);
    }

}
