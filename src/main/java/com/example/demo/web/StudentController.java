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
       studentService.testsave();
       return studentService.showall();
   }

   @ResponseBody
   @RequestMapping(value = "/login")
   String login(String stuname,String password){
      return studentService.login(stuname,password);
   }
}
