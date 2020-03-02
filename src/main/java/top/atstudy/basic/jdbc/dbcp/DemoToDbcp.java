package top.atstudy.basic.jdbc.dbcp;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DemoToDbcp {

    public static void main(String[] args) throws Exception {

//        getConnection();

        getConnection02();

    }

    private static void getConnection() throws SQLException {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.93.33.48:3306/aibs");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");


        Connection conn = dataSource.getConnection();
        System.out.println(" ===>> conn: " + conn.toString());
    }

    private static void getConnection02() throws Exception {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties"));
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        Connection conn = dataSource.getConnection();
        System.out.println(" ===>> conn: " + conn.toString());
    }

}
