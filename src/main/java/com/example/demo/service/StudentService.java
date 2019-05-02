package com.example.demo.service;

import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<StudentDomain> showall();

    //查询单个用户
    StudentDomain findByStudentName(String name);

    //登录
    String login(String stuname,String password);

    void studentsave(StudentDomain studentDomain);

    //删除不属于学校的用户
    void deletename(String stuname, String school);

}

