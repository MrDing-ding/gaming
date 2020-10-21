package com.qfedu.core.type;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 17:43
 * @description:
 */
public enum RType {
    成功(1),失败(2),登录失败(3);

    private int val;

    public int getVal() {
        return val;
    }

    private RType(int v){
        val=v;
    }
}
