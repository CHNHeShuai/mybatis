package com.jerry.mybatis.sqlsession;

import com.jerry.mybatis.configuration.HsConfiguration;
import com.jerry.mybatis.excutor.HsExecutor;

/**
 * sqlsession
 * @AUTHOR hs
 * @DATE 2021/5/2 9:45
 */
public class HsSqlSession {

    //操作数据库相关
    private HsExecutor executor;

    //配置相关
    private HsConfiguration configuration;

    public HsSqlSession(HsExecutor executor, HsConfiguration configuration) {
        this.executor = executor;
        this.configuration = configuration;
    }

    /**
     * 获取mapper 接口代理对象
     * @param clazz 接口的class
     * @param <T> 返回类型
     */
    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }

    /**
     * 查询方法
     * @param statement sql语句
     * @param parameter 参数
     * @param <T>
     */
    public <T> T selectOne(String statement, Object parameter){
        return executor.query(statement,parameter);
    }
}
