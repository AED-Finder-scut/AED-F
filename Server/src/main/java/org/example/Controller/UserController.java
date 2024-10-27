package org.example.Controller;

import jakarta.annotation.Resource;
import org.example.entities.Result;
import org.example.entities.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if(user.getUsername() == null || user.getPassword() == null) {
            return Result.error("请输入用户名或密码");
        }
        user = userService.login(user);
        if(user.getUserId() == -1L) {
            return Result.error("账号有误");
        }//账号不正确
        else if(user.getUserId() == -2L){
            return Result.error("密码有误");
        }//密码不正确
        return Result.success(user);
    }//登录操作

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if(user.getUsername() == null &&  user.getPassword() == null) {
            return Result.error("用户名和密码不能为空");
        }
        else if(user.getPassword() == null) {
            return Result.error("密码不能为空");
        }
        else if(user.getUsername() == null) {
            return Result.error("用户名不能为空");
        }
        else if(userService.selectByname(user.getUsername()) != null) {
            return Result.error("用户名已被使用");
        }
        userService.insertUser(user);
        return Result.success(null);
    }//注册操作
}
