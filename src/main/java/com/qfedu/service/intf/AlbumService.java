package com.qfedu.service.intf;

import com.qfedu.kataba.dto.AlbumDto;
import com.qfedu.kataba.dto.AlbumUpdateDto;
import com.qfedu.kataba.vo.R;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:24
 */
public interface AlbumService{
    //新建
    R save(String token, AlbumDto dto);
    //修改
    R update(String token, AlbumUpdateDto dto);
    //查询
    R query(String token);
}