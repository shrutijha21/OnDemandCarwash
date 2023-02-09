package com.cap.customerservice.services;

import com.cap.customerservice.model.CustomerInfo;

import java.util.List;
import java.util.Optional;

public interface CustomerInfoService {
    public CustomerInfo insertCustomerInfo(CustomerInfo customerId);
    public List<CustomerInfo> getAllCustomers();
     public Optional<CustomerInfo> findCustomerInfoById(int customerId);
    public CustomerInfo findByCustomerEmail(String customerEmail);

    public CustomerInfo updateCustomerInfo(CustomerInfo customerInfo, int customerId);
    public void deleteCustomerInfo(int customerId);

    CustomerInfo getCustomerById(int customerId);
}
