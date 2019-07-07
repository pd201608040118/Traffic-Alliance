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
    StudentDomain login(@RequestParam("stuId") String stuId, @RequestParam("password") String password) {
        return studentService.login(stuId, password);
    }

    //注册
    @RequestMapping(value = "/regedit")
    @ResponseBody
    int regedit(@RequestParam("school1") String school1, @RequestParam("stuId1") String stuId1,
                @RequestParam("stuName1") String stuName1, @RequestParam("tel1") String tel1,
                @RequestParam("profession1") String profession1, @RequestParam("password1") String password1) {
        return studentService.studentsave(school1, stuId1, stuName1, tel1, profession1, password1);
    }


    //显示个人信息
    @RequestMapping(value = "/showuser")
    StudentDomain showuser(@RequestParam("stuId")String stuId){
        return studentService.showuser(stuId);
    }

    //更新个人信息
    @RequestMapping(value = "/update")
    int update(@RequestParam("school") String school, @RequestParam("stuid") String stuid,
               @RequestParam("stuname")String stuname, @RequestParam("tel") String tel,
               @RequestParam("profession")String profession,  @RequestParam("password")String password) {
        return studentService.studentupdate(school, stuid, stuname, tel, profession, password);
    }

    //查找文件
    @RequestMapping(value = "/selectinfor")
    List<InforDomain> selectinfor(@RequestParam("author") String author) {
        return studentService.findInforByInforSchool(author);
    }
}
