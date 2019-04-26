package com.example.demo.service.serviceimpl;

import com.example.demo.dao.StudentDao;
import com.example.demo.dao.domain.LoginDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    StudentDomain studentDomain=new StudentDomain();

    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentService studentService;
    public List<StudentDomain> showall(){
        return studentDao.showall();
    }

    @Override
    public StudentDomain findByStudentName(String studentname) {
        return studentDao.findByStudentName(studentname);
    }

    @Override
    public String login(String stuname,String password) {
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

    @Override
    public void studentsave(StudentDomain studentDomain) {

    }

    public void testsave(){
        for(int i=1;i<100;i++){
            StudentDomain studentDomain=new StudentDomain();
            studentDomain.setStuId("201608040109"+i);
            studentDomain.setStuName("zhanghao"+i);
            studentDomain.setPassword("123456");
            studentDomain.setSchool("中原工学院");
            studentDomain.setProfession("软件工程");
            studentDomain.setTel("15239944424");
            studentDao.studentsave(studentDomain);
        }
    }
}
