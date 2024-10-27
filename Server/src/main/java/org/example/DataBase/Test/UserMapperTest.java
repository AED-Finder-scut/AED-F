package org.example.DataBase.Test;

import org.apache.ibatis.session.SqlSession;
import org.example.DataBase.AedTable.MyBatisUtils;
import org.example.entities.User;
import org.example.mapper.UserMapper;

import java.util.List;

public class UserMapperTest {
    public static void main(String[] args) {
        // 创建一个新的 User 实例
        User newUser = new User(null, "testUser_4", "admin", "testPassword");

        // 测试插入 User
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insert(newUser);
            session.commit(); // 提交事务
            System.out.println("添加 User: " + newUser.getUsername() + ", ID: " + newUser.getUserId());
        }

        // 测试查询所有 User
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> userList = mapper.selectAll();
            System.out.println("所有 Users:");
            for (User user : userList) {
                System.out.println(user);
            }
        }

        // 测试根据 ID 查询 User
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User foundUser = mapper.selectById(newUser.getUserId().intValue()); // 转换为 int
            System.out.println("查找 User ID " + newUser.getUserId() + ": " + foundUser);
        }

        // 测试更新 User
        newUser.setPassword("updatedPassword");
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.update(newUser);
            session.commit(); // 提交事务
            System.out.println("更新 User ID " + newUser.getUserId() + " 的密码");
        }

        // 测试根据用户名查询 User
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User foundByName = mapper.selectByname("testUser");
            System.out.println("查找 User by username: " + foundByName);
        }

        //  测试根据 ID 删除 User
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.deleteById(newUser.getUserId().intValue()); // 转换为 int
            session.commit(); // 提交事务
            System.out.println("删除 User ID " + newUser.getUserId());
        }

        try(SqlSession session=MyBatisUtils.getSqlSession()){
            UserMapper mapper=session.getMapper(UserMapper.class);
            mapper.deleteByname(newUser.getUsername());
            session.commit();
            System.out.println("删除 User Name"+ newUser.getUsername());
        }

        // 再次查询所有 User 以确认删除
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> userList = mapper.selectAll();
            System.out.println("删除后所有 Users:");
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}
