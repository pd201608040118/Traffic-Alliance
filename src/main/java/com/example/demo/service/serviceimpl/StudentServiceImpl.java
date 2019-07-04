package com.example.demo.service.serviceimpl;

import com.example.demo.dao.StudentDao;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.ReturnDomain;
import com.example.demo.dao.domain.StudentDomain;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    ReturnDomain returnDomain = new ReturnDomain();

    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentService studentService;

    public List<StudentDomain> showall() {
        return studentDao.showall();
    }

    @Override
    public StudentDomain showuser(String stuId) {
        return studentDao.showuser(stuId);
    }

    @Override
    public StudentDomain findByStudentId(String studentid) {
        return studentDao.findByStudentId(studentid);
    }

    @Override
    public StudentDomain login(String stuid, String password) {
        StudentDomain student = new StudentDomain();
        student = studentService.findByStudentId(stuid);
        return student;
    }

    //注册
    @Override
    public int studentsave(String school, String stuId, String stuName, String tel, String profession, String password) {
        StudentDomain studentDomain1;
        studentDomain1 = studentService.findByStudentId(stuId);
        if (stuId != null & stuName != null & tel != null & profession != null & password != null) {
            if (studentDomain1 == null) {
                studentDao.studentsave(school, stuId, stuName, tel, profession, password);
                return returnDomain.getR1();
            } else
                return returnDomain.getR2();
        } else
            return returnDomain.getR0();
    }

    @Override
    public int studentupdate(String School, String StuId, String StuName, String Tel, String Profession, String Password) {
        if (School == null || StuId == null || StuName == null ||
                Tel == null || Profession == null)
            return returnDomain.getR0();
        else {
            StudentDomain studentDomain1;
            studentDomain1 = studentService.findByStudentId(StuId);
            if (studentDomain1 == null)
                return returnDomain.getR2();
            else {
                studentDomain1.setSchool(School);
                studentDomain1.setStuId(StuId);
                studentDomain1.setProfession(Profession);
                studentDomain1.setStuName(StuName);
                studentDomain1.setPassword(Password);
                studentDomain1.setTel(Tel);
                studentDao.studentupdate(studentDomain1);
                return returnDomain.getR1();
            }
        }
    }

    @Override
    public List<InforDomain> findInforByInforSchool(String author) {
        return studentDao.findInforByInforSchool(author);
    }

    //填充数据库
/*    public void testsave(int m, int n) {
        for (int i = m; i < n; i++) {
            StudentDomain studentDomain = new StudentDomain();
            studentDomain.setStuId("" + i);
            studentDomain.setStuName("zh" + i);
            studentDomain.setPassword("123456");
            studentDomain.setSchool("中原工学院");
            studentDomain.setProfession("学生");
            studentDomain.setTel("" + i);
            studentDao.studentsave(studentDomain);
        }
    }*/
}
