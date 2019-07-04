package com.example.demo.web;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/traffic/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    //登录
    @RequestMapping(value = "/login")
    AdminDomain login(@RequestParam("schoolid") String schoolid,
                      @RequestParam("password") String password) {
        return adminService.login(schoolid, password);
    }

    //查看个人信息
    @RequestMapping(value = "/showadmin")
    AdminDomain showadmin(@RequestParam("schoolid") String schoolid) {
        return adminService.showadmin(schoolid);
    }

    //发布信息
    @RequestMapping(value = "/uploadinfo")
    int uploadinfo(@RequestParam("title") String title, @RequestParam("conent") String conent,
                   @RequestParam("inforTime") Date inforTime, @RequestParam("author") String author) {
        return adminService.uploadinfo(title, conent, inforTime, author);
    }

    //查找学校所有发布的文件
    @RequestMapping(value = "/findInforByInforSchool")
    List<InforDomain> findInforByInforSchool(@RequestParam("author") String author) {
        return adminService.findInforByInforSchool(author);
    }

    //删除已发布的文件
    @RequestMapping(value = "deleteinfor")
    int deleteinfor(@RequestParam("title") String title) {
        return adminService.deleteinfor(title);
    }

    //更改上传的文本信息
    @RequestMapping(value = "/updateInfor")
    int updateInfor(@RequestParam("title") String title, @RequestParam("conent") String conent,
                    @RequestParam("inforTime") Date infortime) {
        return adminService.updateinfor(title, conent, infortime);
    }

    //修改个人信息
    @RequestMapping(value = "/alteradmin")
    int alteradmin(@RequestParam("tel") String tel, @RequestParam("adminname") String adminname,
                   @RequestParam("schoolid") String schoolid, @RequestParam("password1") String password1,
                   @RequestParam("password2") String password2) {
        return adminService.alteradmin(tel, adminname, schoolid, password1, password2);
    }

    //删除学校目录下的某个用户
    @RequestMapping(value = "/deletestudent")
    int deletestudent(@RequestParam("stuName") String stuname, @RequestParam("school") String school) {
        return adminService.deletstudent(stuname, school);
    }


    //查找学校下的所有用户
    @RequestMapping(value = "/findstudent")
    List<StudentDomain> findstudent(@RequestParam("school") String school) {
        return adminService.findstudent(school);
    }

    //查找单个学生用户
    @RequestMapping(value = "/onlyfind")
    List<StudentDomain> onlyfind(@RequestParam("stuname")String stuname){
        return adminService.onlyfind(stuname);
    }


}
