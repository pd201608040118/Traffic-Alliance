package com.example.demo.service.serviceimpl;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.ReturnDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    ReturnDomain returnDomain = new ReturnDomain();
    @Autowired
    AdminDao adminDao;
    @Autowired
    AdminService adminService;

    //删除学校下的某一用户
    @Override
    public String deletstudent(String stuname, String school) {
        StudentDomain studentDomain = new StudentDomain();
        studentDomain = adminService.findByAdminId2(stuname, school);
        if (studentDomain.getStuName().equals(null))
            return "查无此人";
        else {
            adminDao.deletstudent(stuname, school);
            return "删除成功";
        }
    }

    //修改个人数据
    @Override
    public String alteradmin(String adminname, String tel, String schoolid) {
        if (adminname == null || tel == null)
            return "姓名和密码不能为空";
        else {
            AdminDomain adminDomain = new AdminDomain();
            adminDomain = adminDao.findByAdminId(schoolid);
            adminDomain.setTel(tel);
            adminDomain.setAdminname(adminname);
            adminDao.alteradmin(adminDomain);
            return "修改成功";
        }
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

    //注册
    @Override
    public AdminDomain login(String schoolid, String password) {
        AdminDomain adminDomain;
        adminDomain = adminService.findByAdminId(schoolid);
        return adminDomain;
    }

    @Override
    public AdminDomain findByAdminId(String schoolid) {
        return adminDao.findByAdminId(schoolid);
    }

    @Override
    public StudentDomain findByAdminId2(String stuname, String school) {
        return adminDao.findByAdminId2(stuname, school);
    }

    @Override
    public String updateinfor(String title, Date infortime, String conent) {
        if (title == null || infortime == null || conent == null)
            return "标题、时间、信息不能为空";
        else {
            InforDomain inforDomain = new InforDomain();
            inforDomain = adminDao.findByInforAuthor(title);
            if (inforDomain.getTitle().equals(null))
                return "查无此项,请检查数据输入";
            else {
                inforDomain.setInforTime(infortime);
                inforDomain.setConent(conent);
                adminDao.updateInfor(inforDomain);
                return "修改成功";
            }
        }
    }


}
