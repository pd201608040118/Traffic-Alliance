package com.example.demo.web;

import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/traffic/admin")
public class AdminController extends StudentController {

    @Autowired
    AdminService adminService;

    //删除学校目录下的某个用户
    @RequestMapping(value = "/deletestudent")
    String deletestudent(String stuname, String school) {
        adminService.deletstudent(stuname, school);
        return "删除成功";
    }
    //修改个人信息
    @RequestMapping(value = "/alteradmin")
    String alteradmin(String schoolname, String tel, String adminname, String schoolid, String password) {
        adminService.alteradmin(schoolname, tel, adminname, schoolid, password);
        return "修改成功";
    }
    //查找学校下的所有用户
    @RequestMapping(value = "/findstudent")
    List<StudentDomain> findstudent(String school) {
        return adminService.findstudent(school);
    }
    //发布信息
    @RequestMapping(value = "/uploadinfo")
    String uploadinfo(String title, String conent, Date inforTime, String author) {
        adminService.uploadinfo(title, conent, inforTime, author);
        return "上传成功";
    }

}
