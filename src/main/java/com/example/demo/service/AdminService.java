package com.example.demo.service;

import com.example.demo.dao.domain.StudentDomain;

import java.util.Date;
import java.util.List;

public interface AdminService {
    /*
    对旗下用户的删改查,发布信息,查找信息,修改个人发布信息
     */
    //删除学校下的某一用户
    void deletstudent(String stuname, String school);

    //修改个人数据(根据学校查询并更改信息)
    void alteradmin(String schoolsame, String tel, String adminname, String schoolid, String password);

    //查找学校下的所有用户
    List<StudentDomain> findstudent(String school);

    //发布信息
    void uploadinfo(String title, String conent, Date inforTime, String author);

}
