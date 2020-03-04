package top.atstudy.basic.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.util.Properties;

public class DemoToDruid {

    public static void main(String[] args) throws Exception {

        getConnection();

    }

    private static void getConnection() throws Exception {

        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("druid.properties"));

        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        System.out.println(" ===>> conn: " + dataSource.getConnection().toString());

    }

}
