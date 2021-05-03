package com.jerry.mybatis.test;

import com.jerry.mybatis.configuration.HsConfiguration;
import com.jerry.mybatis.excutor.HsSimpleExecutor;
import com.jerry.mybatis.mapper.ShopMapper;
import com.jerry.mybatis.model.Shop;
import com.jerry.mybatis.sqlsession.HsSqlSession;

/**
 * @AUTHOR hs
 * @DATE 2021/5/2 19:43
 */
public class Test {
    public static void main(String[] args) {
        HsSqlSession session = new HsSqlSession(new HsSimpleExecutor(),new HsConfiguration());
        ShopMapper mapper = session.getMapper(ShopMapper.class);
        Shop shop = mapper.selectOne(1);
        System.out.println(shop);
    }
}
