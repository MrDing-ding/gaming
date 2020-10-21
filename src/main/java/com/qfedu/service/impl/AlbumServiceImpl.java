package com.qfedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.kataba.dao.AlbumDao;
import com.qfedu.kataba.dao.AlbumLogDao;
import com.qfedu.kataba.dto.AlbumDto;
import com.qfedu.kataba.dto.AlbumUpdateDto;
import com.qfedu.kataba.entity.Album;
import com.qfedu.kataba.entity.AlbumLog;
import com.qfedu.kataba.service.intf.AlbumService;
import com.qfedu.kataba.util.TockenUtil;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/21 21:57
 * @description:
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao dao;
    @Autowired
    private AlbumLogDao logDao;
    @Override
    @Transactional
    public R save(String token, AlbumDto dto) {
        //获得uid
        int uid = TockenUtil.getId(token);
        //实例化相册对象
        Album album = new Album(uid, dto.getTitle(), dto.getInfo(), dto.getType(), new Date());
        //插入表
        int insert = dao.insert(album);
        if (insert>0){
            System.out.println(album.getId());
            logDao.insert(new AlbumLog(album.getId(),uid+"-创建相册",1,new Date()));
            return R.ok();
        }
        return R.fail();
    }

    @Override
    public R update(String token, AlbumUpdateDto dto) {
        int uid = TockenUtil.getId(token);

        if (dao.updateTitle(dto)>0) {
            //更新日志
            logDao.insert(new AlbumLog(dto.getId(),uid+"-创建相册",2,new Date()));
            return R.ok();
        }
        return R.fail();
    }

    @Override
    public R query(String token) {
        int uid = TockenUtil.getId(token);
        QueryWrapper<Album> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        queryWrapper.orderByDesc("ctime");
        return R.ok(dao.selectList(queryWrapper)) ;
    }
}
