package com.cap.adminservicecar.services;

import com.cap.adminservicecar.models.AdminData;

import java.util.List;

public interface AdminDataService {

    public AdminData insertAdminData(AdminData adminData);
    public List<AdminData> getAllAdmins();

    public AdminData getAdminDataByUserName(String email);

    public AdminData updateAdminData(AdminData adminData, int adminId);

    public void deleteAdminData(int adminId);
}
