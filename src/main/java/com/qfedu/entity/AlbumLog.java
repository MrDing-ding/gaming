package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_albumlog")
@NoArgsConstructor
public class AlbumLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer aid;
    private String info;
    private Integer type;
    private Date ctime;

    public AlbumLog(Integer aid, String info, Integer type, Date ctime) {
        this.aid = aid;
        this.info = info;
        this.type = type;
        this.ctime = ctime;
    }
}
