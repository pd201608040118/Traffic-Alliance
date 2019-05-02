package com.example.demo.service.serviceimpl;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDao adminDao;
    @Autowired
    AdminService adminService;

    @Override
    public void insertStudent(String School, String StuId, String StuName, String Tel, String Profession, String Password) {
        AdminDomain adminDomain=new AdminDomain();
        adminDomain.setStuId(StuId);
        adminDomain.setStuName(StuName);
        adminDomain.setPassword(Password);
        adminDomain.setSchool(School);
        adminDomain.setProfession(Profession);
        adminDomain.setTel(Tel);
        adminDao.insertStudent(adminDomain);
    }

    @Override
    public void findstudent(String School) {
        AdminDomain adminDomain=new AdminDomain();
        adminDomain.setSchool(School);
        adminDao.findstudent(adminDomain);
    }

    @Override
    public void deletstudent(String School) {
        AdminDomain adminDomain=new AdminDomain();
        adminDomain.setSchool(School);
        adminDao.deletstudent(adminDomain);
    }

    @Override
    public List<AdminDomain> showallA() {
        return adminDao.showallA();
    }

    @Override
    public void alterstudent(String School, String StuId, String StuName, String Tel, String Profession, String Password) {
        AdminDomain adminDomain=new AdminDomain();
        adminDomain.setStuId(StuId);
        adminDomain.setStuName(StuName);
        adminDomain.setPassword(Password);
        adminDomain.setSchool(School);
        adminDomain.setProfession(Profession);
        adminDomain.setTel(Tel);
        adminDao.alterstudent(adminDomain);
    }

}
