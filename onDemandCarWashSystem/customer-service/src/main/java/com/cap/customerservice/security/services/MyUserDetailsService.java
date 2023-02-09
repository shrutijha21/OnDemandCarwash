package com.cap.customerservice.security.services;



import com.cap.customerservice.model.CustomerInfo;
import com.cap.customerservice.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

@Autowired
   private CustomerInfoRepository customerInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomerInfo customerInfo =customerInfoRepository.findByCustomerEmail(email);
//        if(CustomerInfo== null) {
//            return new UsernameNotFoundException(email);
//        }
//        else {
           String username=customerInfo.getCustomerEmail();
           String password=customerInfo.getCustomerPassword();
            return new User(username, password, new ArrayList<>());
//        }
        //return new User("foo", "foo", new ArrayList<>());
    }
}

