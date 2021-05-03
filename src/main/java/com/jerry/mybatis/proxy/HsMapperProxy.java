package com.jerry.mybatis.proxy;

import com.jerry.mybatis.configuration.HsConfiguration;
import com.jerry.mybatis.sqlsession.HsSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @AUTHOR hs
 * @DATE 2021/5/2 18:08
 */
public class HsMapperProxy implements InvocationHandler {

    private HsSqlSession sqlSession;

    public HsMapperProxy(HsSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(HsConfiguration.TestMapperXml.namespace)){
            String sql = HsConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
