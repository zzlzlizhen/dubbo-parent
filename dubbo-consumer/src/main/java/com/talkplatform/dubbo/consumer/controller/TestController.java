package com.talkplatform.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.talkplatform.dubbo.api.service.TestService;
import com.talkplatform.dubbo.common.BaseController;
import com.talkplatform.dubbo.entity.test.Student;
import com.talkplatform.dubbo.entity.test.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lizhen01
 * @date: 2019/11/4 17:09
 * @desc:
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Reference(version = "${application.version}")
    private TestService testService;

    @GetMapping("/getTeacher")
    public String getTestStudent(){
        try {
            Teacher teacher = testService.getTeacher();
            return value(teacher);
        }catch (Exception e){
            return error(e);
        }
    }

    @GetMapping("/getStudentList")
    public String getStudentList(){
        try {
            Teacher teacher = testService.getTeacher();
            List<Student> studentList = testService.getStudentByTeacher(teacher);
            return list(studentList);
        }catch (Exception e){
            return error(e);
        }
    }

    @GetMapping("/getSysError")
    public String getSysError(){
        try {
            int i = 1/0;
            return success();
        }catch (Exception e){
            return error(e);
        }
    }

    @GetMapping("/getBusinessError")
    public String getBusinessError(){
        try {
            Student student = testService.getStudent();
            testService.print(student);
            return success();
        }catch (Exception e){
            return error(e);
        }
    }

}
