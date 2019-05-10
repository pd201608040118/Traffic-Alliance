package com.example.demo.service;

import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<StudentDomain> showall();

    //查询单个用户
    StudentDomain findByStudentId(String id);

    //登录
    String login(String stuid,String password);

    void studentsave(StudentDomain studentDomain);



    //    修改个人信息
    void studentupdate(String school, String stuid, String stuname, String tel, String profession, String password);

    //    查找文本
    List<InforDomain> findInforByInforSchool(String author);
}

