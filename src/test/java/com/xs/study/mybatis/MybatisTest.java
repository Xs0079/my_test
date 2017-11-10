package com.xs.study.mybatis;

import com.xs.study.hibernate.model.PersonEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Xu Sheng on 2017/11/10.
 * mybatis test
 * 注意 Idea默认不加载项目中的src目录下的配置xml文件 既mapper文件，所以需要在项目中单独设置位置及导入。
 */
public class MybatisTest {
    private static SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect() {
        SqlSession session = sessionFactory.openSession();
        PersonEntity person = session.selectOne("com.xs.study.mybatis.PersonMapper.findByName", "张三");
        System.out.println(person);
    }
}
