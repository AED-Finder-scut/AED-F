package main.java.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ade_find_scut";
        String username = "root";
        String password = "123456";

        try {
            // 手动注册驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");  // 确保使用正确的驱动类
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            System.out.println("无法加载 MySQL 驱动！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}