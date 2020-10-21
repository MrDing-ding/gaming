package com.qfedu.util;

import com.qfedu.kataba.config.RedisKeyConfig;
import com.qfedu.kataba.third.JedisUtil;
import org.json.JSONObject;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/21 20:49
 * @description:
 */
public class TockenUtil {
    //获得用户id
    public static int getId(String token){
        return new JSONObject(JedisUtil.getInstance().STRINGS.get(RedisKeyConfig.LOGIN_TOKEN+token)).getInt("id");
    }
}
