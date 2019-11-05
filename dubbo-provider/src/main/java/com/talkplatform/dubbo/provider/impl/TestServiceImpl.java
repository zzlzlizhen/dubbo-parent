package com.talkplatform.dubbo.provider.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.talkplatform.dubbo.api.service.TestService;
import com.talkplatform.dubbo.common.exception.ProviderException;
import com.talkplatform.dubbo.provider.utils.TestUtils;
import com.talkplatform.dubbo.entity.test.Student;
import com.talkplatform.dubbo.entity.test.Teacher;

import java.util.List;

/**
 * @author: lizhen01
 * @date: 2019/11/4 16:09
 * @desc:
 */
@Service(version = "${application.version}")
public class TestServiceImpl implements TestService {

    @Override
    public void testDubbo() throws ProviderException {
        System.out.println("hello world");
    }

    @Override
    public void print(Student student) throws ProviderException {
        System.out.println(JSONUtil.toJsonStr(student));
        throw new ProviderException(501,"测试异常");
    }

    @Override
    public Teacher getTeacher() throws ProviderException {
        Teacher teacher = TestUtils.buildOneTeacher(3);
        return teacher;
    }

    @Override
    public Student getStudent() throws ProviderException {
        Student student = TestUtils.buildOneStudent();
        return student;
    }

    @Override
    public List<Student> getStudentByTeacher(Teacher teacher) throws ProviderException {
        if(ObjectUtil.isNull(teacher)){
            return null;
        }
        return teacher.getStudentList();
    }
}
