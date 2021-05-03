package com.jerry.mybatis.excutor;

import com.jerry.mybatis.model.Shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @AUTHOR hs
 * @DATE 2021/5/2 18:35
 */
public class HsSimpleExecutor implements HsExecutor {
    @Override
    public <T> T query(String statement, Object parameter) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Shop shop = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/classshop","root","1223yspa");
            pstmt = conn.prepareStatement(String.format(statement,Integer.parseInt(parameter+"")));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                shop = new Shop();
                shop.setId(rs.getLong(1));
                shop.setCategoryId(rs.getLong(2));
                shop.setName(rs.getString(3));
                shop.setLevel(rs.getInt(4));
                shop.setPrice(rs.getInt(5));
                shop.setSmallImg(rs.getString(6));
                shop.setIntroduce(rs.getString(7));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return (T)shop;
    }
}
