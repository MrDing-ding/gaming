package com.qfedu.service.impl;

import com.qfedu.kataba.dao.AlbumLogDao;
import com.qfedu.kataba.service.intf.AlbumLogService;
import com.qfedu.kataba.util.TockenUtil;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/21 22:28
 * @description:
 */
public class AlbumLogServiceImpl implements AlbumLogService {
    @Autowired
    private AlbumLogDao dao;

    @Override
    public R query(int aid) {
        return R.ok();
    }

    @Override
    public R queryAll(String token) {
        int uid= TockenUtil.getId(token);
        return R.ok(dao.all(uid));
    }
}
