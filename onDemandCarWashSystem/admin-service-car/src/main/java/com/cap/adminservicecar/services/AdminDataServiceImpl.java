package com.cap.adminservicecar.services;

import com.cap.adminservicecar.models.AdminData;
import com.cap.adminservicecar.repository.AdminDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDataServiceImpl implements AdminDataService{

    @Autowired
    AdminDataRepository adminDataRepository;

    @Override
    public AdminData insertAdminData(AdminData adminData) {
        return adminDataRepository.save(adminData);
    }

    @Override
    public List<AdminData> getAllAdmins() {
        return adminDataRepository.findAll();
    }

    @Override
    public AdminData getAdminDataByUserName(String email) {
         return adminDataRepository.findByUserName(email);
    }

    @Override
    public AdminData updateAdminData(AdminData adminData, int adminId) {
        AdminData aD= adminDataRepository.findById(adminId).get();
        aD.setUserName(adminData.getUserName());
        aD.setPassword(adminData.getPassword());
        return adminDataRepository.save(aD);
    }

    @Override
    public void deleteAdminData(int adminId) {
            adminDataRepository.deleteById(adminId);
    }
}
