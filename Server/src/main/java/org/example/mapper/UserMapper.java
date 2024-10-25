package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entities.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into users (user_id, username, name_type, password)"+
    "values (#{userId}, #{username}, #{name_type}, #{password})")
    void insert(User user);

    @Update("update 'users' set user_id = #{userId},username = #{username}, name_type = #{nameType}, password = #{password}")
    void update(User user);

    @Delete("delete from users where user_id = #{id}")
    void delete(Integer id);

    @Select("select * from 'users' order by user_id desc")
    List<User> selectAll();

    @Select("select * from 'users' where id = #{id} order by user_id desc")
    User selectById(Integer id);

    @Select("select * from 'users' where username = #{username} order by user_id desc")
    User selectByname(String username);
}
