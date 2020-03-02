package top.atstudy.basic.jdbc.base;

import top.atstudy.basic.jdbc.JdbcTest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    public static Connection getConnection() throws IOException, SQLException {
        InputStream is = JdbcTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        Connection conn = DriverManager.getConnection((String) properties.get("url"), properties);
        System.out.println(conn);
        return conn;
    }


}
