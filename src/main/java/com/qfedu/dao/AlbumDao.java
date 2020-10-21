package com.qfedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.kataba.dto.AlbumUpdateDto;
import com.qfedu.kataba.entity.Album;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:24
 */
@Repository
public interface AlbumDao extends BaseMapper<Album> {
    @Update("update t_album set title=#{title},info=#{info} where id=#{id}")
    int updateTitle(AlbumUpdateDto dto);
}
