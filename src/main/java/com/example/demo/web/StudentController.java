package com.example.demo.web;

import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.serviceimpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/traffic/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    //填充数据库
    @RequestMapping(value = "/test")
    List<StudentDomain> test(int m, int n) {
        studentService.testsave(m, n);
        return studentService.showall();
    }

    @RequestMapping(value = "/login")
    String login(String stuid, String password) {
        return studentService.login(stuid, password);
    }

    @RequestMapping(value = "/deletename")
    String deletename(String stuname, String school) {
        studentService.deletename(stuname, school);
        return "用户删除成功";
    }
}
