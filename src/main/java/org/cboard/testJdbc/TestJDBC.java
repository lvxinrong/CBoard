package org.cboard.testJdbc;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/5/15.
 */
public class TestJDBC {

    private final static String url = "jdbc:mysql://10.166.1.52:3306/ICCS_LM_SIT";
    private final static String userName = "root";
    private final static String password = "yuntong1112";

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,userName,password);
            String sql = "select * from dashboard_board";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                //metaData.getColumnLabel(i + 1);
                System.out.println("metaData :" + metaData.getColumnLabel(i + 1));
            }
            while (rs.next()) {
                for (int j = 0; j < columnCount; j++) {
                    System.out.println("ResultSet :" + rs.getString(j + 1));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
