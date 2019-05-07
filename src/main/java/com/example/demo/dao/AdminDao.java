package com.example.demo.dao;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface AdminDao extends StudentDao {
/*
对旗下用户的删改查,发布信息,查找信息,修改个人发布信息
 */

    //删除学校下的单个用户
    void deletstudent(StudentDomain studentDomain);

    //修改个人信息
    void alteradmin(AdminDomain adminDomain);

    //查找学校下的所有用户
    List<StudentDomain> findstudent(String school);

    //发布信息
    void uploadinfo(@Param("title") String title,
                    @Param("conent")String conent,
                    @Param("inforTime")Date inforTime,
                    @Param("author")String author);

}
