package com.why.project.common;
import com.why.project.entity.Zwkmye2020;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtils {

    // 声明一个连接对象，用来获取数据库连接，注意此Connection来自java.sql.DriverManager; ，不要导入错了。
    static Connection connection = null;
    // 创建一个声明
    static PreparedStatement pst = null;

    static {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";//Mysql名字
        String password = "admin";//Mysql连接密码
        // 注册数据库的驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 获取数据库连接
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            List<Zwkmye2020> list = null;
            list = select();
            for (Zwkmye2020 p : list) {
                System.out.println(p.toString());
            }
            System.out.println();//换行
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Zwkmye2020> selectZwkmye() {
        try {
            return select();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //查找全部的User表格数据
    private static List<Zwkmye2020> select() throws SQLException {
        List<Zwkmye2020> list = new ArrayList<Zwkmye2020>();
        //创建查询语句
        String sql = "select zwkmye_dwbh, zwkmye_kmbh, zwkmye_jffs, zwkmye_dffs, zwkmye_jflj, " +
                "zwkmye_dflj, zwkmye_dqye, zwkmye_kjq, zwkmye_kjnd, zwkmye_ncye from zwkmye_2020";

        // 定义一个结果集合，用来存放读取的数据
        ResultSet rs = null;
        //执行查询
        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery();//得到结果集
        Zwkmye2020 p = null;
        while (rs.next()) {
            p = new Zwkmye2020();
            p.setZwkmyeDwbh(rs.getString("zwkmye_dwbh"));
            p.setZwkmyeKmbh(rs.getString("zwkmye_kmbh"));
            p.setZwkmyeJffs(rs.getBigDecimal("zwkmye_jffs"));
            p.setZwkmyeDffs(rs.getBigDecimal("zwkmye_dffs"));
            p.setZwkmyeJflj(rs.getString("zwkmye_jflj"));
            p.setZwkmyeDflj(rs.getString("zwkmye_dflj"));
            p.setZwkmyeDqye(rs.getBigDecimal("zwkmye_dqye"));
            p.setZwkmyeKjq(rs.getString("zwkmye_kjq"));
            p.setZwkmyeKjnd(rs.getString("zwkmye_kjnd"));
            p.setZwkmyeNcye(rs.getDouble("zwkmye_ncye"));
            list.add(p);
        }

        return list;
    }

}