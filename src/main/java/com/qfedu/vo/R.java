package com.qfedu.vo;

import com.qfedu.kataba.core.type.RType;
import lombok.Data;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 18:00
 * @description:
 */
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;
    public static <T> R setR(Integer code, String m, T d){
        R r=new R();
        r.setCode(code);
        r.setData(d);
        r.setMsg(m);
        return r;
    }
    //成功(返回数据为null)
    public static <T> R ok(){
        return setR(RType.成功.getVal(),"OK",null);
    }
    //成功
    public static <T> R ok(T data){
        return setR( RType.成功.getVal(),"OK",data);
    }
    //失败
    public static <T> R fail(){
        return setR(RType.失败.getVal(),"FAIL",null);
    }


}
