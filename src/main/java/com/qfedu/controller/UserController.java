package com.qfedu.controller;

import com.qfedu.kataba.dto.UserDto;
import com.qfedu.kataba.dto.UserLoginDto;
import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.service.intf.UserService;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 19:39
 * @description:
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("all.do")
    public R<List<User>> login(){
        R<List<User>> allUser = userService.findAllUser();
        return allUser;
    }
    @GetMapping("checkPhone.do")
    public  R checkPhone(String phone){
        return  userService.checkPhone(phone);
    }
    @GetMapping("checkNickname.do")
    public  R checkNickname(String nickname){
        return  userService.checkNickname(nickname);
    }
    @PostMapping("register.do")
    public R register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }
    @PostMapping("login.do")
    public R login(@RequestBody UserLoginDto userLoginDto){
        return userService.login(userLoginDto);
    }

}
