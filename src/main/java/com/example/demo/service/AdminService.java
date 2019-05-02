package com.example.demo.service;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.StudentDomain;

import java.util.List;

public interface AdminService {
    //增加用户
    void insertStudent(String School, String StuId, String StuName, String Tel, String Profession, String Password);
    //查找单一用户
    void findstudent(String School);
    //删除用户
    void deletstudent(String School);
    //显示全部用户
    List<AdminDomain> showallA();
    //修改用户数据
    void alterstudent(String School, String StuId, String StuName, String Tel, String Profession, String Password);
}
