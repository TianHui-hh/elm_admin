package com.tianhui.util;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PASSWORD = "root";
    private static final String USERNAME = "root";

    //获取connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭资源
    public static void close(ResultSet rs, PreparedStatement pst, Connection con) throws SQLException {

        if (pst != null) {
            pst.close();
            pst = null;
        }

        if (rs != null) {
            rs.close();
            rs = null;
        }

        if (con != null) {
            con.close();
            con = null;
        }

    }


}
