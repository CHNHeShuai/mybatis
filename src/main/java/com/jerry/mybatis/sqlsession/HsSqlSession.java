package com.jerry.mybatis.sqlsession;

import com.jerry.mybatis.configuration.HsConfiguration;
import com.jerry.mybatis.excutor.HsExcutor;

/**
 * sqlsession
 * @AUTHOR hs
 * @DATE 2021/5/2 9:45
 */
public class HsSqlSession {

    //操作数据库相关
    private HsExcutor excutor;

    //配置相关
    private HsConfiguration configuration;

    public HsSqlSession(HsExcutor excutor, HsConfiguration configuration) {
        this.excutor = excutor;
        this.configuration = configuration;
    }
}
