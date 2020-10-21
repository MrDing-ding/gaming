package com.qfedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.kataba.config.RedisKeyConfig;
import com.qfedu.kataba.dao.UserDao;
import com.qfedu.kataba.dao.UserLogDao;
import com.qfedu.kataba.dto.UserDto;
import com.qfedu.kataba.dto.UserLoginDto;
import com.qfedu.kataba.entity.User;
import com.qfedu.kataba.entity.Userlog;
import com.qfedu.kataba.service.intf.UserService;
import com.qfedu.kataba.third.JedisUtil;
import com.qfedu.kataba.third.JwtUtil;
import com.qfedu.kataba.util.EncryptUtil;
import com.qfedu.kataba.util.StrUtil;
import com.qfedu.kataba.vo.R;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 19:34
 * @description:
 */
@Service
public class UserServceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLogDao userLogDao;
    @Value("${kataba.passkey}")
    private String pk;
    @Override

    public R<List<User>> findAllUser() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        List<User> users = userDao.selectList(userQueryWrapper);
        R ok = R.ok(users);
        return ok;
    }

    @Override
    public R checkPhone(String phone) {
        User user = userDao.selectOne(new QueryWrapper<User>().eq("phone",phone));
        if (StrUtil.checkNoEmpty(phone)){
            if (user != null) {
                //存在，不可用
                return R.fail();
            }else {
                return R.ok();
            }

        }
        return R.fail();
    }

    @Override
    public R checkNickname(String nickname) {
        User user = userDao.selectOne(new QueryWrapper<User>().eq("nickname",nickname));
        if (StrUtil.checkNoEmpty(nickname)){
            if (user != null) {
                //存在，不可用
                return R.fail();
            }else {
                return R.ok();
            }

        }
        return R.fail();
    }



    @Override
    @Transactional
    public R register(UserDto userDto) {
        User user = userDao.selectByNamePhone(userDto.getNickname(), userDto.getPhone());
        if (user == null) {
            //密码 密文 AES
            userDto.setPassword(EncryptUtil.aesenc(pk,userDto.getPassword()));
            //插入到数据库
            int insert = userDao.insert(new User(userDto.getPhone(), userDto.getPassword(), userDto.getNickname(), 1));
            if (insert>0){
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                QueryWrapper<User> phone = queryWrapper.eq("phone", userDto.getPhone());
                User user1 = userDao.selectOne(phone);
                userLogDao.insert(new Userlog(user1.getId(),1,"注册新用户",new Date()));
                return R.ok();
            }



        }
        return R.fail();
    }

    @Override
    public R login(UserLoginDto userLoginDto) {
        //验证昵称或者号码是否存在或正确
        User user = userDao.selectByName(userLoginDto.getName());
        if (user != null) {
            //校验密码是否正确
            if (user.getPassword().equals(EncryptUtil.aesenc(pk,userLoginDto.getPassword()))){
                //生成一个令牌
                String token = JwtUtil.createToken(user.getPhone());
                //将一个令牌存在redis中
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_TOKEN + token, RedisKeyConfig.LOGIN_TIME, new JSONObject(user).toString());
                //记录用户登录记录在Redis中
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_USER+user.getId(),RedisKeyConfig.LOGIN_TIME,token);
                userLogDao.insert(new Userlog(user.getId(),2,"登录"+user.getId(),new Date()));
                return R.ok(token);
            }

        }
        return R.fail();
    }

    @Override
    public R findPass(UserDto userDto) {
        return null;
    }


}
