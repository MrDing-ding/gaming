package com.qfedu.service.impl;

import com.qfedu.kataba.config.RedisKeyConfig;
import com.qfedu.kataba.dao.SmsLogDao;
import com.qfedu.kataba.dto.SmsRCodeDto;
import com.qfedu.kataba.entity.Smslog;
import com.qfedu.kataba.service.intf.SmsLogService;
import com.qfedu.kataba.third.JedisUtil;
import com.qfedu.kataba.third.SmsUtil;
import com.qfedu.kataba.util.NumRandomUtil;
import com.qfedu.kataba.util.StrUtil;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 17:27
 * @description:
 */
@Service
public class SmsLogServiceImpl implements SmsLogService {
    @Autowired
    private SmsLogDao smsLogDao;
    @Override
    public R sendRcode(String phone) {
        //生成验证码
        int i = NumRandomUtil.randomNum(6);
        System.out.println(i);
        //发送验证码
        if (SmsUtil.sendRCode(phone,i)){
            //存储验证码
            JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.SMS_RCODE+phone,RedisKeyConfig.RCODE_TIME,i+"");
            //新增注册日志
            smsLogDao.insert(new Smslog(phone,1,"注册时发送的验证码",new Date()));
            return R.ok();
        }
        return R.fail();
    }

    @Override
    public R checkRcode(SmsRCodeDto smsRCodeDto) {
        //判断电话号码是否为空
        if(StrUtil.checkNoEmpty(smsRCodeDto.getPhone())){
            String phone = RedisKeyConfig.SMS_RCODE + smsRCodeDto.getPhone();
            //判断是否失效
            if (JedisUtil.getInstance().getJedis().exists(phone)) {
                if (smsRCodeDto.getCode() == Integer.parseInt(JedisUtil.getInstance().STRINGS.get(phone))) {
                    return R.ok();
                }

            }

        }
           return R.fail();
    }
}
