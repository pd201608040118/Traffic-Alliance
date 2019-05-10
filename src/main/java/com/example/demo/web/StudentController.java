package com.example.demo.web;

import com.example.demo.dao.domain.InforDomain;
import com.example.demo.service.serviceimpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/traffic/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/login")
    String login(String stuid, String password) {
        return studentService.login(stuid, password);
    }

    @RequestMapping(value = "/update")
    void update(String school, String stuid, String stuname, String tel, String profession, String password){
        studentService.studentupdate(school,stuid,stuname,tel,profession,password);
    }

    @RequestMapping(value = "/selectinfor")
    List<InforDomain> selectinfor(String school){
        return studentService.findInforByInforSchool(school);
    }
}
