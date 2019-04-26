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
    public List<StudentDomain> showall(){
        return studentDao.showall();
    }

    @Override
    public StudentDomain findByStudentName(String studentname) {
        return studentDao.findByStudentName(studentname);
    }

    @Override
    public String login(LoginDomain loginDomain,String stuname,String password) {
        if (loginDomain.getLoginStuName().equals(stuname)&&loginDomain.getLoginStuName().equals(password)){
            return "TRUE";
        }
        else
            return "FLASE";
    }
}
