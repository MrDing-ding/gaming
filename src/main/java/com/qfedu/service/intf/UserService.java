package com.qfedu.service.intf;

import com.qfedu.kataba.dto.UserDto;
import com.qfedu.kataba.dto.UserLoginDto;
import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.vo.R;

import java.util.List;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 19:32
 * @description:
 */
public interface UserService {
    R<List<User>> findAllUser();
    //检验手机号
    R checkPhone(String phone);
    //校验昵称
    R checkNickname(String nickname);
    //注册
    R register(UserDto userDto);
    //登录
    R login(UserLoginDto userLoginDto);
    //找回密码
    R findPass(UserDto userDto);
}
