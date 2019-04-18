package com.example.demo.web;

import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.serviceimpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
       return studentService.showall();
   }
}
