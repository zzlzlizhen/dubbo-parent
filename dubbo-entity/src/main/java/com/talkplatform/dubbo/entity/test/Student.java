package com.talkplatform.dubbo.entity.test;

/**
 * @author: lizhen01
 * @date: 2019/11/4 16:17
 * @desc:
 */
public class Student extends BaseEntity {

    private Long stuId;

    private String stuName;

    private Integer age;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
