package com.iweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 要解决事务问题：
 * 1、在同一个连接内
 * 2、数据不要自动提交,等到所有代码执行完了，再提交
 * 3、出了问题，可以回滚
 */
public class Trscat {
    public static void main(String[] args) {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        //1、加载驱动
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.连接数据库
        Connection conn = null;
        PreparedStatement pstm = null;
        try {

            Integer jine = 2000;

            conn = DriverManager.getConnection(url,username,password);

            conn.setAutoCommit(false);//设置不要自动提交

            //3、预编译sql语句
            pstm = conn.prepareStatement("update account set money = money + ? where id =?");

            //4 执行sql语句
            pstm.setInt(1,-2000);
            pstm.setInt(2,10001);
            pstm.executeUpdate();

            int i = 10/0;

            //清除第一个人的参数
            pstm.clearParameters();

            pstm.setInt(1,2000);
            pstm.setInt(2,10002);
            pstm.executeUpdate();

            //程序执行到最后了，再提交
            conn.commit();
        } catch (Exception e) {
            try {
                //程序出现异常，回滚
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {

            if(pstm!=null)
            {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
