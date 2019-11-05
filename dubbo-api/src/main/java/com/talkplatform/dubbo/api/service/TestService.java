package com.talkplatform.dubbo.api.service;

import com.talkplatform.dubbo.common.exception.ProviderException;
import com.talkplatform.dubbo.entity.test.Student;
import com.talkplatform.dubbo.entity.test.Teacher;

import java.util.List;

/**
 * @author: lizhen01
 * @date: 2019/11/4 16:07
 * @desc:
 */
public interface TestService {

    void testDubbo() throws ProviderException;

    void print(Student student) throws ProviderException;

    Teacher getTeacher() throws ProviderException;

    Student getStudent() throws ProviderException;

    List<Student> getStudentByTeacher(Teacher teacher) throws ProviderException;

}
