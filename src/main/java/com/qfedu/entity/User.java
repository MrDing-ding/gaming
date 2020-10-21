package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 17:54
 * @description: 用户实体类
 */
@Data
@TableName("t_user")
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String password;
    private String nickname;
    private int flag; //1 表示有效, 2 表示无效

    public User(String phone, String password, String nickname, int flag) {
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.flag = flag;
    }
}
