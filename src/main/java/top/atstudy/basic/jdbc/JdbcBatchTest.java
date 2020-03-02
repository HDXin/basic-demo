package top.atstudy.basic.jdbc;

import top.atstudy.basic.demo.IDUtil;
import top.atstudy.basic.jdbc.base.JdbcUtils;

import java.io.*;
import java.sql.*;
import java.text.ParseException;

public class JdbcBatchTest {


    public static void main(String[] args) throws IOException, SQLException, ParseException {

        // 新增
        addBatch(1070000, 30000, 500);

    }

    /**
     * 批量新增
     * @param rows
     * @param size
     * @throws IOException
     * @throws SQLException
     * @throws ParseException
     */
    private static void addBatch(Integer baseId, Integer rows, Integer size) throws IOException, SQLException, ParseException {

        //ID主键
        IDUtil idUtil = IDUtil.instance();

        //1、获取连接
        Connection conn = JdbcUtils.getConnection();
        System.out.println("===>> conn: " + conn.toString());

        //设置成手动提交事务
        conn.setAutoCommit(false);

        //2、预编译sql
        String sql = "insert into sys_log(id, type, name, phone) values(?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        long start = System.currentTimeMillis();
        //3、填充数据
        for (int i = 1; i <= rows; i++) {
            long id = new Long(baseId + i);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, "type" + i);
            preparedStatement.setString(3, "name" + i);
            preparedStatement.setString(4, "189" + i);

            preparedStatement.addBatch();
            if(i % size == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }

        //手动提交事务
        conn.commit();

        //总耗时
        long end = System.currentTimeMillis();
        System.out.println(" ===>> 总耗时：" + (end - start));

        if(conn != null) {
            conn.close();
        }

        if(preparedStatement != null){
            preparedStatement.close();
        }

    }

}
