package com.qfedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.entity.AlbumLog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:24
 */
@Repository
public interface AlbumLogDao extends BaseMapper<AlbumLog> {
    @Select("select al.* from t_albumlog al inner join t_album a on a.id=al.aid where a.uid=#{uid}")
    List<AlbumLog> all(int uid);
}
