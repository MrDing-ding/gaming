package com.qfedu.service.intf;

import com.qfedu.kataba.dto.AlbumShareDto;
import com.qfedu.kataba.vo.R;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:24
 */
public interface AlbumShareService {
    //创建
    R save(String token, AlbumShareDto dto);
    //修改  停止分享
    R stopShare(int id);
}
