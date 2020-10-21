package com.qfedu.service.intf;

import com.qfedu.kataba.dto.SmsRCodeDto;
import com.qfedu.kataba.vo.R;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 17:24
 * @description:
 */
public interface SmsLogService {
    //发送验证码
    R sendRcode(String phone);
    //验证验证码
    R checkRcode(SmsRCodeDto smsRCodeDto);
}
