package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:20
 */
@Data
@TableName("t_album")
@NoArgsConstructor
public class Album {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private String title;
    private String info;
    private Integer type;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date ctime;

    public Album(Integer uid, String title, String info, Integer type, Date ctime) {
        this.uid = uid;
        this.title = title;
        this.info = info;
        this.type = type;
        this.ctime = ctime;
    }
}
