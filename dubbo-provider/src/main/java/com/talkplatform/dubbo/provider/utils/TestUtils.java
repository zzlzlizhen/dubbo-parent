package com.talkplatform.dubbo.provider.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.talkplatform.dubbo.entity.test.Student;
import com.talkplatform.dubbo.entity.test.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lizhen01
 * @date: 2019/11/4 16:44
 * @desc:
 */
public class TestUtils {

    public final static String STUDENT = "stu_";
    public final static String TEACHER = "tea_";

    public static Student buildOneStudent(){
        Student student = new Student();
        student.setStuId(RandomUtil.randomLong());
        student.setStuName(STUDENT+RandomUtil.randomString(10));
        student.setAge(RandomUtil.randomInt(100));
        return student;
    }

    public static Teacher buildOneTeacher(Integer studentNum){
        Teacher teacher = new Teacher();
        teacher.setTeaId(RandomUtil.randomLong());
        teacher.setTeaName(TEACHER+RandomUtil.randomString(10));
        teacher.setAge(RandomUtil.randomInt(100));
        if(ObjectUtil.isNotNull(studentNum)){
            List<Student> list = new ArrayList<Student>();
            for(int i=0;i<studentNum.intValue();i++){
                list.add(buildOneStudent());
            }
            teacher.setStudentList(list);
        }
        return teacher;
    }
}
