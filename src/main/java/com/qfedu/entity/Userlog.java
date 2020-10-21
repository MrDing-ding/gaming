package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 11:23
 * @description:
 */
@Data
@TableName("t_userlog")
@NoArgsConstructor
public class Userlog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private int type;
    private String content;
    private Date ctime;

    public Userlog(Integer uid, int type, String content, Date ctime) {
        this.uid = uid;
        this.type = type;
        this.content = content;
        this.ctime = ctime;
    }
}
