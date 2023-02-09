package com.cap.adminservicecar.security.services;


import com.cap.adminservicecar.models.AdminData;
import com.cap.adminservicecar.repository.AdminDataRepository;
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
   private AdminDataRepository adminInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminData adminInfo =adminInfoRepository.findByUserName(email);
//        if(adminInfo== null) {
//            return new UsernameNotFoundException(email);
//        }
//        else {
           String username=adminInfo.getUserName();
           String password=adminInfo.getPassword();
            return new User(username, password, new ArrayList<>());
//        }
        //return new User("foo", "foo", new ArrayList<>());
    }
}

