package com.qfedu.controller;

import com.qfedu.kataba.dto.SmsRCodeDto;
import com.qfedu.kataba.service.intf.SmsLogService;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/21 21:13
 * @description:
 */
@RestController
@RequestMapping("/api/sms")
public class SmsControler {
    @Autowired
    private SmsLogService smsLogService;
    @GetMapping("sendRcode.do")
    public R sendRcode(String phone){
        return smsLogService.sendRcode(phone);
    }
    @GetMapping("checkRcode.do")
    public R checkRcode(SmsRCodeDto smsRCodeDto){
        return smsLogService.checkRcode(smsRCodeDto);
    }
}
