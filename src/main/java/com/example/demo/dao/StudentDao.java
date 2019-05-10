package com.example.demo.dao;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {

    //    查询出当前存在的所有用户信息
    List<StudentDomain> showall();

    //    实现登录和返回登录信息
    String login(String stuid, String password);

    //    通过学生id进行查询，用于实现用户登录与注册
    StudentDomain findByStudentId(String id);

    //    实现用户注册存储功能
    void studentsave(StudentDomain studentDomain);

    //    修改个人信息
    void studentupdate(StudentDomain studentDomain);

    //    查找文本
    List<InforDomain> findInforByInforSchool(String author);
}
