package com.talkplatform.dubbo.provider;

import cn.hutool.core.util.RandomUtil;
import com.talkplatform.dubbo.provider.dao.BaseCourseLessonDao;
import com.talkplatform.dubbo.provider.dao.SeriesTextbookDao;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboProviderApplicationTests {

    @Autowired
    private SeriesTextbookDao seriesTextbookDao;

    @Autowired
    private BaseCourseLessonDao baseCourseLessonDao;

    @Test
    void testTextbookRead() {
        System.out.println(seriesTextbookDao.queryId(847561L));
    }

    //7988214
    @Test
    void testCourseReadAndWrite(){
        String title = "hello world "+ RandomUtil.randomStringUpper(10);
        System.out.println(baseCourseLessonDao.queryById(7988214L));
        System.out.println(title);
        baseCourseLessonDao.updateById(7988214L,title);
        System.out.println(baseCourseLessonDao.queryById(7988214L));
    }

}
