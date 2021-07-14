package com.doney.advanced.mybatisDemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MyBatis 简单测试
 */
public class MybatisDemo01 {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SQL sql = new SQL(); //SQL 构建
        String s = sql.
                SELECT("datatype")
                .SELECT("areacode")
                .FROM("tab2010601")
                .WHERE("timeval > '2020-01-01'").toString();

        List<Object> objects = sqlSession.selectList(sql.toString());

    }
}
