package com.cap.adminservicecar.controller;


import com.cap.adminservicecar.models.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    String customerUrl="http://localhost:8082/customer/";

    @PostMapping("/add")
    public CustomerInfo insertCustomerInfo(@RequestBody CustomerInfo CustomerInfo){

        //sending the RequestBody
        RequestEntity<CustomerInfo> request = RequestEntity
                .post(customerUrl+"add")
                .accept(MediaType.APPLICATION_JSON)
                .body(CustomerInfo);
        ResponseEntity<CustomerInfo> response = restTemplate.exchange(request, CustomerInfo.class);
        CustomerInfo cI=response.getBody();
        return cI;

        //return restTemplate.getForObject(customerUrl+"add", CustomerInfo.class);
    }

    @GetMapping("/view")
    public CustomerInfo[] getAllCustomers(){
        ResponseEntity<CustomerInfo[]> response=restTemplate.getForEntity(customerUrl+"view", CustomerInfo[].class);
        CustomerInfo[] cI=response.getBody();
        return cI;
    }



    @PutMapping("/update/{id}")
    public CustomerInfo updateCustomerInfo(@RequestBody CustomerInfo CustomerInfo, @PathVariable("id") int Customerd)
    {
        RequestEntity<CustomerInfo> request = RequestEntity
                .put(customerUrl+"update/"+Customerd)
                .accept(MediaType.APPLICATION_JSON)
                .body(CustomerInfo);
        ResponseEntity<CustomerInfo> response = restTemplate.exchange(request, CustomerInfo.class);
        CustomerInfo cI=response.getBody();
        return cI;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCustomerInfo(@PathVariable("id") int customerId)
    {
        restTemplate.delete(customerUrl+"delete/" + customerId);
    }



}
