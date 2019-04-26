package com.example.demo.service;

import com.example.demo.dao.domain.LoginDomain;
import com.example.demo.dao.domain.StudentDomain;

import java.util.List;

public interface StudentService {
    List<StudentDomain> showall();

    StudentDomain findByStudentName(String name);

    String login(LoginDomain loginDomain,String stuname,String password);
}

