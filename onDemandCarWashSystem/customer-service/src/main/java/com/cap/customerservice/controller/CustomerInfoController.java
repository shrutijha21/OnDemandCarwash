package com.cap.customerservice.controller;

import com.cap.customerservice.model.CustomerInfo;
import com.cap.customerservice.model.WashPack;
import com.cap.customerservice.services.CustomerInfoService;
import com.cap.customerservice.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerInfoController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    CustomerInfoService customerInfoService;

    @GetMapping("/")
    public String getCustomer(){
        return "hii Customer";
    }

    @Validated
    @PostMapping("/add")
    public CustomerInfo insertUserInfo(@RequestBody @Valid CustomerInfo customerInfo) {
//        customerInfo.setCustomerId(sequenceGeneratorService.getSequenceNumber(CustomerInfo.SEQUENCE_NAME));
        return customerInfoService.insertCustomerInfo(customerInfo);
    }

    @GetMapping("/view")
    public List<CustomerInfo> getAllUsers() {
        return customerInfoService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfo> getCustomerById(@PathVariable("id") int id){
        CustomerInfo cI=customerInfoService.getCustomerById(id);
        return ResponseEntity.ok(cI);
    }

    @GetMapping("/view/{email}")
    public CustomerInfo getByCustomerEmail(@PathVariable("email") String customerEmail){
        return customerInfoService.findByCustomerEmail(customerEmail);
    }

    @Validated
    @PutMapping("/update/{id}")
    public CustomerInfo updateUserInfo(@RequestBody @Valid CustomerInfo customerInfo, @PathVariable("id") int userId) {
        return customerInfoService.updateCustomerInfo(customerInfo, userId);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUserInfo(@PathVariable("id") int customerId) {

        customerInfoService.deleteCustomerInfo(customerId);

    }

//    @Autowired
//    private RestTemplate restTemplate;

//    @GetMapping("/get")
//    public WashPack[] getWashPacks() {
//        ResponseEntity<WashPack[]> response = restTemplate.getForEntity("http://localhost:8081/washpack/viewall/", WashPack[].class);
//        WashPack[] washPacks = response.getBody();
//        return (washPacks);
//
//    }
}
