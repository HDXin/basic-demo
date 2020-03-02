package top.atstudy.basic.jdbc;

import top.atstudy.basic.jdbc.base.JdbcUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;

public class JdbcPrepareTest {


    public static void main(String[] args) throws IOException, SQLException, InstantiationException, IllegalAccessException {

        // 新增
//        createTest(1L, "Jerry", 55, "17889899090");

        // 编辑
//        updateTest(555L, "JerryXX", 556, "17889899077");

        // 删除
//        deleteTest(555L);

        queryTest(1L);

    }

    private static void queryTest(Long id) throws SQLException, IOException, IllegalAccessException, InstantiationException {

        //1、获取连接
        Connection conn = JdbcUtils.getConnection();;
        System.out.println("===>> conn: " + conn.toString());

        //2、预编译sql
        String sql = "select id, name, age age, phone, photo from demo where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //3、填充数据
        preparedStatement.setLong(1, id);

        //4、执行插入
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Field[] fields = DemoEntity.class.getDeclaredFields();
            DemoEntity entity = DemoEntity.class.newInstance();
            for(Field field:fields){
                field.setAccessible(true);
                field.set(entity, resultSet.getObject(field.getName()));
            }

            if(entity.getPhoto() != null){
                InputStream is = entity.getPhoto();

                FileOutputStream fos = new FileOutputStream(new File("F:\\temp\\22.jpeg"));
                int len = 0;
                byte[] b = new byte[1024];
                while ((len = is.read(b)) != -1){
                    fos.write(b, 0, len);
                }
            }
            System.out.println(" ===>> result: " + entity.toString());
        }

        if(conn != null) {
            conn.close();
        }

        if(preparedStatement != null){
            preparedStatement.close();
        }
    }

    /**
     * 删除
     * @param id
     * @throws SQLException
     * @throws IOException
     */
    private static void deleteTest(Long id) throws SQLException, IOException {
        //1、获取连接
        Connection conn = JdbcUtils.getConnection();;
        System.out.println("===>> conn: " + conn.toString());

        //2、预编译sql
        String sql = "delete from demo where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //3、填充数据
        preparedStatement.setLong(1, id);

        //4、执行插入
        Boolean rows = preparedStatement.execute();
        System.out.println(" ===>> rows: " + rows);

        if(conn != null) {
            conn.close();
        }

        if(preparedStatement != null){
            preparedStatement.close();
        }
    }

    /**
     * 编辑
     * @param id
     * @param name
     * @param age
     * @param phone
     * @throws SQLException
     * @throws IOException
     */
    private static void updateTest(Long id, String name, Integer age, String phone) throws SQLException, IOException {


        //1、获取连接
        Connection conn = JdbcUtils.getConnection();;
        System.out.println("===>> conn: " + conn.toString());

        //2、预编译sql
        String sql = "update demo set name = ?, age = ?, phone = ? where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //3、填充数据
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, phone);
        preparedStatement.setLong(4, id);

        //4、执行插入
        int rows = preparedStatement.executeUpdate();
        System.out.println(" ===>> rows: " + rows);

        if(conn != null) {
            conn.close();
        }

        if(preparedStatement != null){
            preparedStatement.close();
        }

    }

    /**
     * 新增
     * @param id
     * @param name
     * @param age
     * @param phone
     * @throws IOException
     * @throws SQLException
     */
    private static void createTest(Long id, String name, Integer age, String phone) throws IOException, SQLException {

        //1、获取连接
        Connection conn = JdbcUtils.getConnection();
        System.out.println("===>> conn: " + conn.toString());

        //2、预编译sql
        String sql = "insert into demo(id, name, age, phone, photo) values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //3、填充数据
        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        preparedStatement.setString(4, phone);

        FileInputStream fis = new FileInputStream(new File("F:\\temp\\11.jpeg"));
        preparedStatement.setAsciiStream(5, fis);

        //4、执行插入
        Boolean row = preparedStatement.execute();
        System.out.println(" ===>> insert: " + row);

        if(conn != null) {
            conn.close();
        }

        if(preparedStatement != null){
            preparedStatement.close();
        }

    }

}
