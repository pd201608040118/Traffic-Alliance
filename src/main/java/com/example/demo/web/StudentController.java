package com.example.demo.web;

import com.example.demo.dao.domain.LoginDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.serviceimpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/traffic")
public class StudentController {

   @Autowired
   StudentServiceImpl studentService;
   @ResponseBody
   @GetMapping(value = "/test")
   @Test
   List<StudentDomain> test(){
//       String name="zhanghao";
//       String password="123456";
//       login(name,password);
       return studentService.showall();
   }

   @ResponseBody
   @PostMapping(value = "/login")
   String login(String stuname,String password){
      StudentDomain student=new StudentDomain();
      student=studentService.findByStudentName(stuname);

      if(student.getStuName().equals(null)){
         return "用户不存在，登录失败";
      }
      else if (!student.getPassword().equals(password)){
         return "密码错误，登录失败";
      }
      return "登录成功";
   }
}
