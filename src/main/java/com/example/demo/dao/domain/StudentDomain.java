package com.example.demo.dao.domain;

public class StudentDomain {
    private String School;
    private Long StuId;
    private String StuName;
    private Long Tel;
    private String Profession;
    private String Password;

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public Long getStuId() {
        return StuId;
    }

    public void setStuId(Long stuId) {
        StuId = stuId;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public Long getTel() {
        return Tel;
    }

    public void setTel(Long tel) {
        Tel = tel;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
