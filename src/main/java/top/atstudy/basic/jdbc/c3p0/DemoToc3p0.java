package top.atstudy.basic.jdbc.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DemoToc3p0 {

    /**
     * 数据库连接池
     * @param args
     * @throws PropertyVetoException
     * @throws SQLException
     */
    public static void main(String[] args) throws PropertyVetoException, SQLException {

        //测试
//        getConnection();

        //项目做法
        getConnection02();

    }

    private static void getConnection() throws PropertyVetoException, SQLException {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://47.93.33.48:3306/aibs");
        cpds.setUser("root");
        cpds.setPassword("123456");

        cpds.setInitialPoolSize(10);
        cpds.setMaxConnectionAge(100);

        Connection conn = cpds.getConnection();
        System.out.println(" ===>> conn: " + conn.toString());
    }

    private static void getConnection02() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hello-c3p0");
        Connection conn = cpds.getConnection();

        System.out.println(" ===>> " + conn.toString());
    }

}
