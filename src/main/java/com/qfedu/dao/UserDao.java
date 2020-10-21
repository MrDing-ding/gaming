package com.qfedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 19:30
 * @description:
 */
@Repository
public interface UserDao extends BaseMapper<User> {
    @Select("select * from t_user  where nickname=#{nickname} or phone=#{phone}")
    @ResultType(User.class)
    User selectByNamePhone(@Param("nickname") String nickname, @Param("phone") String phone);

    @Select("select * from t_user  where nickname=#{n} or phone=#{n}")
    @ResultType(User.class)
    User selectByName(String n);

}
