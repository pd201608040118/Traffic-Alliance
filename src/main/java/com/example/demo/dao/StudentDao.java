package com.example.demo.dao;

import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    //    查询出当前存在的所有用户信息
    List<StudentDomain> showall();
    //    实现登录和返回登录信息
    String login(String stuname, String password);
    //    通过学生姓名进行查询，用于实现用户登录与注册
    StudentDomain findByStudentName(String stuname);
    //    实现用户注册存储功能
    void studentsave(StudentDomain studentDomain);
    //    删除隶属于学校的个人用户
    void deletename(@Param("stuname") String stuname, @Param("school") String school);
}
