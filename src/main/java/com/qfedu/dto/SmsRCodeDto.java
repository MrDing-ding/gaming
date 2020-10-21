package com.qfedu.dto;

import lombok.Data;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/20 16:46
 * @description:
 */
@Data
public class SmsRCodeDto {
    private String phone;
    private int code;
}
