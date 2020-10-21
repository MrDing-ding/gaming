package com.qfedu.third;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.qfedu.kataba.util.StrUtil;
import org.json.JSONObject;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 18:00
 * @description: 短信服务
 */
public class SmsUtil {
    private static final String accessKeyId = "LTAI4GGEDdAHoscQnVrZk3Ta";
    private static final String accessKeySecret = "U7l8jYLfl4ALq1xTySDa8x4RoATUjF";
    //短信发送
    public static boolean sendRCode(String phone,int code){
        //配置对象
        DefaultProfile profile = DefaultProfile.
                getProfile("cn-hangzhou",
                        accessKeyId,
                        accessKeySecret);
        //实例化短信发送对象
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求对象
        CommonRequest request = new CommonRequest();
        //设置请求方式
        request.setSysMethod(MethodType.POST);
        //设置短信服务的地址
        request.setSysDomain("dysmsapi.aliyuncs.com");
        //系统版本号
        request.setSysVersion("2017-05-25");
        //调用的接口
        request.setSysAction("SendSms");
        //设置域
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //设置签名
        request.putQueryParameter("SignName", "来自丁利明的短信");
        //设置模板
        request.putQueryParameter("TemplateCode", "SMS_114390520");
        //设置手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //设置验证码
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            //接收响应
            CommonResponse response = client.getCommonResponse(request);
            String json=response.getData();
            if(StrUtil.checkNoEmpty(json)) {
                JSONObject jo=new JSONObject(json);
                return jo.getString("Code").equals("OK");
            }
        }catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}