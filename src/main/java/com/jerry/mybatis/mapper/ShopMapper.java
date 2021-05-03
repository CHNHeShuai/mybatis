package com.jerry.mybatis.mapper;


import com.jerry.mybatis.model.Shop;

/**
 * @AUTHOR hs
 * @DATE 2021/5/1 21:25
 */
public interface ShopMapper {

    Shop selectOne(Integer id);
}
