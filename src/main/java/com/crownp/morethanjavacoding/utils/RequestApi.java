package com.crownp.morethanjavacoding.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author qgp
 * @Date 2019/10/25 17:33
 **/
public class RequestApi {
    public static void main(String[] args) {
        post();
    }

    /**
     * post请求、带header、带文件传参
     *
     * 使用HashMap传参会自动获取类型
     *
     * get请求同理
     */
    public static void post(){
        HashMap<String, String> headers = new HashMap<>();
        //token
        headers.put("Digark-Api-Header","bf1c13d238874e04a9928f159712d65d8691e4573ca64e9e9a8905b27b81c448");
        String result = HttpUtil.createPost("192.168.2.112:8081/v1/api_sensi")
                .addHeaders(headers)
                .form("sample",FileUtil.file("F:\\123.docx"))
                .form("mode",2)
                .execute()
                .body();
        System.out.println(result);
    }
}
