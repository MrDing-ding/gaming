package com.qfedu.config;


/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 17:43
 * @description:
 */
public class RedisKeyConfig {
    //存储某手机验证码
    public final static String SMS_RCODE = "kataba:sms:rcode:"; //后面追加电话号码
    public final static int RCODE_TIME = 600;
    //存储令牌
    public final static String LOGIN_TOKEN = "kataba:login:token:"; //追加令牌
    public static final int LOGIN_TIME=1800;//单位秒
    public static final String LOGIN_USER="kataba:login:uid:";//追加用户id
}
