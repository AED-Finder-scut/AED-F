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

    public void insertUser(User user) {userMapper.insert(user);}

    public void updateUser(User user) {userMapper.update(user);}

    public List<User> selectAll(){return userMapper.selectAll();}

    public User selectByid(Integer id){return userMapper.selectById(id);}

    public User selectByname(String username){return selectByname(username);}

    public User login(User user) {
        User dbuser = selectByname(user.getUsername());
        if(dbuser == null){
            return new User(-1L);
        }
        if(!user.getPassword().equals(dbuser.getPassword())){
            return new User(-2L);
        }
        return dbuser;
    }
}
