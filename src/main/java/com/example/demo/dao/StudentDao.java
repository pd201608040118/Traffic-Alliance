package com.example.demo.dao;

import com.example.demo.dao.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StudentDao {
    @Select("select * from student")
    List<StudentDomain> showall();
}
