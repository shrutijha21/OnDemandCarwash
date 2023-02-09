package com.cap.customerservice.repository;

import com.cap.customerservice.model.CustomerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerInfoRepository extends MongoRepository<CustomerInfo, Integer> {
    public CustomerInfo findByCustomerEmail(String email);

}
