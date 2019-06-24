package com.example.demo.service;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;

import java.util.Date;
import java.util.List;

public interface AdminService {
    /*
    对旗下用户的删改查,发布信息,查找信息,修改个人发布信息
     */
    //删除学校下的某一用户
    String deletstudent(String stuname, String school);

    //修改个人数据(根据学校查询并更改信息)
    String alteradmin(String adminname,String tel,String schoolid);

    //查找学校下的所有用户
    List<StudentDomain> findstudent(String school);

    //发布信息
    void uploadinfo(String title, String conent, Date inforTime, String author);

    //查找学校所有发布的文件
    List<InforDomain> findInforByInforSchool(String author);

    //实现登录和返回登录信息
    AdminDomain login(String stuid, String password);

    //查找单个用户利用id进行登录
    AdminDomain findByAdminId(String schoolid);

    //查找单个用户通过姓名和学校进行删除
    StudentDomain findByAdminId2(String stuname, String school);

   //修改学校发布信息
   String updateinfor(String title,Date infortime,String conent);

}
