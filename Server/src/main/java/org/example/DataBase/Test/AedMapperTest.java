package org.example.test;

import org.apache.ibatis.session.SqlSession;
import org.example.DataBase.AedTable.MyBatisUtils;
import org.example.entities.AED;
import org.example.mapper.AEDMapper;

import java.util.List;

public class AedMapperTest {
    public static void main(String[] args) {
        // 创建一个新的 AED 实例
        AED newAed = new AED(null, "C17", "C17教师公寓一楼大厅", 23.057886, 113.408575);

        // 测试添加 AED
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = session.getMapper(AEDMapper.class);
            int result = mapper.addAed(newAed);
            session.commit(); // 提交事务
            System.out.println("添加 AED 结果: " + result);
            System.out.println("新增 AED ID: " + newAed.getId());
        }

        // 测试查询所有 AED
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = session.getMapper(AEDMapper.class);
            List<AED> aedList = mapper.getAllAeds();
            System.out.println("所有 AED:");
            for (AED aed : aedList) {
                System.out.println(aed);
            }
        }

        // 测试删除 AED
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = session.getMapper(AEDMapper.class);
            int result = mapper.deleteAed(newAed.getId());
            session.commit(); // 提交事务
            System.out.println("删除 AED ID " + newAed.getId() + " 结果: " + result);
        }

        // 再次查询所有 AED 以确认删除
        try (SqlSession session = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = session.getMapper(AEDMapper.class);
            List<AED> aedList = mapper.getAllAeds();
            System.out.println("删除后所有 AED:");
            for (AED aed : aedList) {
                System.out.println(aed);
            }
        }
    }
}
