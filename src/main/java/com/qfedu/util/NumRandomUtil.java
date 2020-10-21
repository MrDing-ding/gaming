package com.qfedu.util;

import java.util.Random;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 19:18
 * @description:
 */
public class NumRandomUtil {
  //生成指定位数随机数
  public static int randomNum(int len){
      Random random = new Random();
      double d=Math.pow(10,len-1);
      return random.nextInt((int)(Math.pow(10,len)-d))+(int)d;


  }
}
