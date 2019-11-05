package com.talkplatform.dubbo.provider.dao;

import com.talkplatform.dubbo.provider.annotation.Database;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author: lizhen01
 * @date: 2019/11/5 16:03
 * @desc:
 */
@Mapper
@Database("textbook")
public interface SeriesTextbookDao {

    Map queryId(@Param("id")Long id);

}
