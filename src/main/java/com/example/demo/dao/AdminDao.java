package com.example.demo.dao;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao extends StudentDao{

    //增加用户
    void insertStudent(StudentDomain studentDomain);
    //查找单一用户
    void findstudent(AdminDomain adminDomain);
    //删除用户
    void deletstudent(AdminDomain adminDomain);
    //显示全部用户
    List<AdminDomain> showallA();
    //修改用户数据(根据学校查询并更改信息)
    void alterstudent(AdminDomain adminDomain);

}
