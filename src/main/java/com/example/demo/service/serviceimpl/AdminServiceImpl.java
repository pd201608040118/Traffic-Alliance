package com.example.demo.service.serviceimpl;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    //删除学校下的某一用户
    @Override
    public void deletstudent(String stuname, String school) {
        StudentDomain studentDomain = new StudentDomain();
        studentDomain.setStuName(stuname);
        studentDomain.setSchool(school);
        adminDao.deletstudent(studentDomain);
    }

    //修改个人数据(根据学校查询并更改信息)
    @Override
    public void alteradmin(String schoolname, String tel, String adminname, String schoolid, String password) {
        AdminDomain adminDomain = new AdminDomain();
        adminDomain.setSchoolName(schoolname);
        adminDomain.setTel(tel);
        adminDomain.setAdminname(adminname);
        adminDomain.setPassword(password);
        adminDomain.setSchoolid(schoolid);
        adminDao.alteradmin(adminDomain);
    }

    //查找学校下的所有用户
    @Override
    public List<StudentDomain> findstudent(String school) {
        return adminDao.findstudent(school);
    }

    //发布信息
    @Override
    public void uploadinfo(String title, String conent, Date inforTime, String author) {
/*        InforDomain inforDomain = new InforDomain();
        inforDomain.setTitle(title);
        inforDomain.setInformation(information);
        inforDomain.setInforTime(inforTime);
        inforDomain.setAuthor(author);*/
        adminDao.uploadinfo(title,conent,inforTime,author);
    }


}
