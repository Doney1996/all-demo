package com.doney.advanced.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hikari pool 连接池测试
 */
public class DemoHiKari {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://119.45.13.75:3306/go");
        config.setUsername("root");
        config.setPassword("admin1984");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT 1");
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1));
        }
    }
}
