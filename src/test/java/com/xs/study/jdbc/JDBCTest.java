package com.xs.study.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * JDBC 测试类
 * 总结:创建connection连接数据库
 * 利用conncetion创建statement对象，根据statement对象获取查询结果resultSet
 * 其中查询利用executeQuery方法，插入 修改、删除、建表等使用executeUpdate方法。
 * execute方法可以执行任何sql语句。包括存储过程等。
 * ***未测试：未测试一条sql语句返回多个结果集的情况，及批量sql的情况。
 */
public class JDBCTest {
    private static final String url = "jdbc:mysql://192.168.1.101/testDB";
    private static final String username = "xs";
    private static final String password = "xs";
    private static final String driveName = "com.mysql.jdbc.Driver";
    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试mysql连接是否成功
     */
    @Test
    public void testConnection() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDriverName());
            System.out.println("mysql版本号：" + metaData.getDatabaseMajorVersion() + "." + metaData.getDatabaseMinorVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateTable() {
        String sql = "create table person (name varchar(20),sex tinyint)";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println("执行结果" + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        String sql = "insert into person values ('张三','1')";
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println("执行结果" + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect() {
        String sql = "select * from person";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int sex = resultSet.getInt(2);
                System.out.println("执行结果 row : " + resultSet.getRow());
                System.out.println("name : " + name + " ; sex " + sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExecute() {
        String sql = "select now()";
        try {
            Statement statement = connection.createStatement();
            boolean execute = statement.execute(sql);

            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String result = resultSet.getString(1);
                    System.out.println(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
