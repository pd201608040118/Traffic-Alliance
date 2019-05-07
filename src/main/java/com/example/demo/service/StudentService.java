package com.example.demo.service;

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

    //删除不属于学校的用户
    void deletename(String stuname, String school);

}

