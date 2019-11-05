package com.talkplatform.dubbo.entity.test;

import java.util.List;

/**
 * @author: lizhen01
 * @date: 2019/11/4 16:20
 * @desc:
 */
public class Teacher extends BaseEntity {

    private Long teaId;

    private String teaName;

    private Integer age;

    private List<Student> studentList;

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
