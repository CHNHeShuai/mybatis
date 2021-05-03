package com.jerry.mybatis.configuration;

import com.jerry.mybatis.proxy.HsMapperProxy;
import com.jerry.mybatis.sqlsession.HsSqlSession;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR hs
 * @DATE 2021/5/2 9:45
 */
public class HsConfiguration {

    public <T> T getMapper(Class<T> clazz,HsSqlSession sqlSession){
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},new HsMapperProxy(sqlSession));
    }

    /**
     * 模拟解析xml文件
     */
    public static class TestMapperXml{
        public static final String namespace = "com.jerry.mybatis.mapper.ShopMapper";

        public static Map<String,String> methodSqlMapping = new HashMap<>();

        static {
            methodSqlMapping.put("selectOne","select * from shop where shopId = %d ");
        }
    }
}
