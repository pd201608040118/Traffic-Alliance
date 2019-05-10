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
    @Autowired
    AdminService adminService;

    //删除学校下的某一用户
    @Override
    public String deletstudent(String stuname, String school) {
        StudentDomain studentDomain = new StudentDomain();
        studentDomain = adminService.findByAdminId2(stuname,school);
        if (studentDomain.getStuName().equals(null))
            return "查无此人";
        else{
            adminDao.deletstudent(stuname,school);
            return "删除成功";
        }
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
        adminDao.uploadinfo(title, conent, inforTime, author);
    }

    @Override
    public List<InforDomain> findInforByInforSchool(String author) {
        return adminDao.findInforByInforSchool(author);
    }

    @Override
    public String login(String schoolid, String password) {
        AdminDomain adminDomain = new AdminDomain();
        adminDomain = adminService.findByAdminId(schoolid);
        if (adminDomain.getSchoolid().equals(null)) {
            return "用户不存在，登录失败";
        } else if (!adminDomain.getPassword().equals(password)) {
            return "密码错误，登录失败";
        }
        return "登录成功";
    }

    @Override
    public AdminDomain findByAdminId(String schoolid) {
        return adminDao.findByAdminId(schoolid);
    }

    @Override
    public StudentDomain findByAdminId2(String stuname, String school) {
        return adminDao.findByAdminId2(stuname,school);
    }


}
