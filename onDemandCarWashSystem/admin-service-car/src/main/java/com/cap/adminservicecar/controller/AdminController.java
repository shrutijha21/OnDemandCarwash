package com.cap.adminservicecar.controller;

import com.cap.adminservicecar.models.AdminData;
import com.cap.adminservicecar.services.AdminDataService;
import com.cap.adminservicecar.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    AdminDataService adminDataService;

    @PostMapping("/add")
    public AdminData insertAdminData(@RequestBody AdminData adminData){
        adminData.setAdminId(sequenceGeneratorService.getSequenceNumber(AdminData.SEQUENCE_NAME));
        return adminDataService.insertAdminData(adminData);
    }

    @GetMapping("/view")
    public List<AdminData> getAllAdmins(){
        return adminDataService.getAllAdmins();
    }

    @GetMapping("/view/{username}")
    public AdminData getAdminDataByUserName(@PathVariable("username") String email){
        return adminDataService.getAdminDataByUserName(email);
    }

    @PutMapping("/update/{id}")
    public AdminData updateAdminData(@RequestBody AdminData AdminData, @PathVariable("id") int adminId)
    {
        return adminDataService.updateAdminData(AdminData, adminId);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAdminData(@PathVariable("id") int userId)
    {
        adminDataService.deleteAdminData(userId);
    }

}
