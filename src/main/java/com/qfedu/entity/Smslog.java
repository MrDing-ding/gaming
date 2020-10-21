package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 11:28
 * @description:
 */
@Data
@TableName("t_smslog")
@NoArgsConstructor
public class Smslog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private int  type;
    private String content;
    private Date ctime;

    public Smslog(String phone, int type, String content, Date ctime) {
        this.phone = phone;
        this.type = type;
        this.content = content;
        this.ctime = ctime;
    }
}
