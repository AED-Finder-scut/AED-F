package org.example.DataBase;
/*
 * @管理数据库中aed表的工具类，成员均为静态方法
 */

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.example.entities.AED;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class aedTable {

    // 向表中增加一个aed，成功返回true，否则返回false
    static public boolean addAed(AED addToTable) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 数据库连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/aed_finder"; // 数据库连接地址
        String username = "root"; // 用户名
        String password = "1234"; // 密码

        // 创建数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            // 构建 SQL 语句，使用占位符 (?)
            String sql = "INSERT INTO aed (name, description, latitude, longitude) VALUES (?, ?, ?, ?)";

            // 创建 PreparedStatement 对象，并填充参数
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, addToTable.getName());         // 设置 name
            preparedStatement.setString(2, addToTable.getDescription());  // 设置 description
            preparedStatement.setDouble(3, addToTable.getLatitude());     // 设置 latitude
            preparedStatement.setDouble(4, addToTable.getLongitude());    // 设置 longitude

            // 执行插入操作
            int rowsAffected = preparedStatement.executeUpdate();

            // 如果影响的行数大于 0，表示插入成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();  // 打印 SQL 异常信息
            return false;
        } finally {
            // 关闭资源，避免资源泄漏
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    // 在表中以id为索引删除一个aed，成功返回true，否则返回false
    static public boolean deleteAed(Long id) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 数据库连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/aed_finder"; // 数据库连接地址
        String username = "root"; // 用户名
        String password = "1234"; // 密码

        // 创建数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            // 构建 SQL 语句，使用占位符 (?) 来防止 SQL 注入
            String sql = "DELETE FROM aed WHERE id = ?";

            // 创建 PreparedStatement 对象，并设置参数
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id); // 设置删除条件中的 id

            // 执行删除操作
            int rowsAffected = preparedStatement.executeUpdate();

            // 如果影响的行数大于 0，表示删除成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();  // 打印 SQL 异常信息
            return false;
        } finally {
            // 关闭资源，避免资源泄漏
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    //返回表内所有的aed，以list<AED>的形式
    static public List<AED> getAllAeds() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 数据库连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/aed_finder"; // 数据库连接地址
        String username = "root"; // 用户名
        String password = "1234"; // 密码

        List<AED> aedList = new ArrayList<>(); // 用于存储结果的列表
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 创建数据库连接
            connection = DriverManager.getConnection(url, username, password);

            // 构建 SQL 查询语句
            String sql = "SELECT id, name, description, latitude, longitude FROM aed";

            // 创建 PreparedStatement 对象
            preparedStatement = connection.prepareStatement(sql);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            // 处理结果集
            while (resultSet.next()) {
                // 从结果集中获取数据
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");

                // 创建 AED 对象并添加到列表
                AED aed = new AED(id, name, description, latitude, longitude);
                aedList.add(aed);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 打印 SQL 异常信息
        } finally {
            // 关闭资源，避免资源泄漏
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return aedList; // 返回 AED 列表
    }


}
