package top.atstudy.basic.jdbc.druid;

import java.io.IOException;
import java.util.Properties;

public class DemoToDruid {

    public static void main(String[] args) throws IOException {

        getConnection();

    }

    private static void getConnection() throws IOException {

        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("druid.properties"));

//        DataSource dataSource = DruidDataSou

    }

}
