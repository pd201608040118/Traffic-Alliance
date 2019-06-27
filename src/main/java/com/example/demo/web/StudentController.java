package com.example.demo.web;

import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.ReturnDomain;
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

    //登录
    @RequestMapping(value = "/login")
    @ResponseBody
    StudentDomain login(@RequestParam("stuid") String stuid, @RequestParam("password") String password) {
        return studentService.login(stuid, password);
    }

    //注册
    @RequestMapping(value = "/regedit")
    @ResponseBody
    int regedit(@RequestParam("school") String school, @RequestParam("stuId") String stuId,
                @RequestParam("stuName") String stuName, @RequestParam("tel") String tel,
                @RequestParam("profession") String profession, @RequestParam("password") String password) {
        return studentService.studentsave(school, stuId, stuName, tel, profession, password);
    }

    //更新个人信息
    @RequestMapping(value = "/update")
    int update(String school, String stuid, String stuname, String tel, String profession, String password) {
        return studentService.studentupdate(school, stuid, stuname, tel, profession, password);
    }

    //查找文件
    @RequestMapping(value = "/selectinfor")
    List<InforDomain> selectinfor(String author) {
        return studentService.findInforByInforSchool(author);
    }
}
