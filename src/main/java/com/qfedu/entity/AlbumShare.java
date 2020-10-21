package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:20
 */
@Data
@TableName("t_albumshare")
public class AlbumShare {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer aid;
    private Integer uid;
    private String title;
    private String aurl;
    private String acode;
    private Integer type;
    private Integer flag;
    private Date ctime;
}
