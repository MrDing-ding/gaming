package com.qfedu.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 19:27
 * @description:
 */
@Data
@TableName("t_user")
public class UserDto {
    private String phone;
    private String password;
    private String nickname;

}
