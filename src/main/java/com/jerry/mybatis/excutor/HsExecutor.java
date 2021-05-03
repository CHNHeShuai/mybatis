package com.jerry.mybatis.excutor;

/**
 * @AUTHOR hs
 * @DATE 2021/5/2 9:45
 */
public interface HsExecutor {
    <T> T query(String statement, Object parameter);
}
