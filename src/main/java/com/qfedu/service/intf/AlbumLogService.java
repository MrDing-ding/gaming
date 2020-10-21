package com.qfedu.service.intf;

import com.qfedu.kataba.vo.R;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 09:24
 */
public interface AlbumLogService {
    //查询
    R query(int aid);
    R queryAll(String token);
}
