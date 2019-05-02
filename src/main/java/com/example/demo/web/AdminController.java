package com.example.demo.web;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/trafficA")
public class AdminController extends StudentController{

    @Autowired
    AdminService adminService;

    //增加用户
    @RequestMapping(value = "/insertStudent")
    String insertStudent(String School, String StuId, String StuName, String Tel, String Profession, String Password){
        adminService.insertStudent(School,StuId,StuName,Tel,Profession,Password);
        return "用户添加成功";
    }

    //删除用户
    @RequestMapping(value = "/deletStudent")
    String deletStudent(String School){
        adminService.deletstudent(School);
        return "成员删除成功";
    }

    //修改用户数据(根据学校名称查询并更改信息)
    @RequestMapping(value = "alterstudent")
    String  alterstudent(String School, String StuId, String StuName, String Tel, String Profession, String Password){
        adminService.alterstudent(School,StuId,StuName,Tel,Profession,Password);
        return "修改成功";
    }

    //查找单一用户
    @RequestMapping(value = "/findStudent")
    String findStudent(String School){
        adminService.findstudent(School);
        return "成员查找成功";
    }

    //显示全部用户
    @RequestMapping(value = "showall")
    List<AdminDomain> showallA(){ return adminService.showallA(); }

}
