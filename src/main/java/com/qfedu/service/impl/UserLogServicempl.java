package com.qfedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.kataba.dao.UserLogDao;
import com.qfedu.kataba.entity.Userlog;
import com.qfedu.kataba.service.intf.UserLogService;
import com.qfedu.kataba.util.TockenUtil;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 17:28
 * @description:
 */
@Service
public class UserLogServicempl implements UserLogService {
  @Autowired
  private UserLogDao userLogDao;
    @Override
    public R all(String token) {
        int id = TockenUtil.getId(token);
        QueryWrapper<Userlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",id);
        List<Userlog> userlogs = userLogDao.selectList(queryWrapper);
        return R.ok(userlogs);
    }
}
