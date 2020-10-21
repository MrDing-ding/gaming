package com.qfedu.controller;

import com.qfedu.kataba.config.SystemConfig;
import com.qfedu.kataba.service.intf.UserLogService;
import com.qfedu.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/21 21:17
 * @description:
 */
@RestController
@RequestMapping("/api/userlog")
public class UserLogController {
    @Autowired
    private UserLogService userLogService;
    @GetMapping("all")
    public R all(HttpServletRequest request){
        return userLogService.all(request.getHeader(SystemConfig.TOKEN_HEADER));
    }
}
