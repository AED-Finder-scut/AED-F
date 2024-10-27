/*
* aed表的服务类，外部使用导入此类
* */

package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.example.DataBase.AedTable.MyBatisUtils;
import org.example.entities.AED;
import org.example.mapper.AEDMapper;

import java.util.List;

public class AEDService {

    public static boolean addAed(AED aed) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = sqlSession.getMapper(AEDMapper.class);
            int rowsAffected = mapper.addAed(aed);
            sqlSession.commit(); // 提交事务
            return rowsAffected > 0;
        }
    }

    public static boolean deleteAed(Long id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = sqlSession.getMapper(AEDMapper.class);
            int rowsAffected = mapper.deleteAed(id);
            sqlSession.commit(); // 提交事务
            return rowsAffected > 0;
        }
    }

    public static List<AED> getAllAeds() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            AEDMapper mapper = sqlSession.getMapper(AEDMapper.class);
            return mapper.getAllAeds();
        }
    }
}
