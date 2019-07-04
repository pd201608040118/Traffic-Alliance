package com.example.demo.dao;

import com.example.demo.dao.domain.AdminDomain;
import com.example.demo.dao.domain.InforDomain;
import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface AdminDao{
/*
对旗下用户的删改查,发布信息,查找信息,修改个人发布信息
 */

    //删除学校下的单个用户
    void deletstudent(@Param("stuname") String stuname, @Param("school") String school);

    //删除单个文件
    void deleteinfor(@Param("title")String title);

    //修改个人信息
    void alteradmin(AdminDomain adminDomain);

    //查找学校下的所有用户
    List<StudentDomain> findstudent(@Param("school") String school);

    //发布信息
    void uploadinfo(@Param("title") String title,
                    @Param("conent") String conent,
                    @Param("inforTime") Date inforTime,
                    @Param("author") String author);

    //显示个人信息
    AdminDomain showadmin(@Param("schoolid")String schoolid);

    //查找学校所有发布的文件
    List<InforDomain> findInforByInforSchool(String author);

    //查找单个学生用户,通过id查找
    AdminDomain findByAdminId(String schoolid);

    //查找单个学生用户,通过姓名和学校查找
    StudentDomain findByAdminId2(@Param("stuname") String stuname, @Param("author") String school);

    //修改学校发布信息
    void updateInfor(InforDomain inforDomain);

    //查找单个文件,通过标题名称查找
    InforDomain findByInforTitle(@Param("title") String title);

    //查找单个学生用户
    List<StudentDomain> onlyfind(@Param("stuname")String stuname);
}
