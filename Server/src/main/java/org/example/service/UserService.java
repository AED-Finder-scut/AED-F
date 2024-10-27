package org.example.service;

import org.example.entities.User;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user) {userMapper.insert(user);}//增加用户

    public void updateUser(User user) {userMapper.update(user);}//更新用户

    public void deleteById(int id) {userMapper.deleteById(id);}

    public void deletrByname(String username){userMapper.deleteByname(username);}

    public List<User> selectAll(){return userMapper.selectAll();}//查找所有用户

    public User selectByid(Integer id){return userMapper.selectById(id);}//根据id查找用户

    public User selectByname(String username){return userMapper.selectByname(username);}//根据用户名查找用户

    public User login(User user) {
        User dbuser = selectByname(user.getUsername());
        if(dbuser == null){
            return new User(-1L);
        }
        if(!user.getPassword().equals(dbuser.getPassword())){
            return new User(-2L);
        }
        return dbuser;
    }//校验账号密码
}
