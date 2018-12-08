package com.yaorange.service;

import com.yaorange.pojo.TSso;
import com.yaorange.util.Ret;

import javax.servlet.http.HttpSession;

public interface UserService {
    //发送验证码
    void sendSmsCode(String phone, HttpSession session);

    Ret saveByregPhone(String phone, String captcha, String password, String smsCaptcha,HttpSession session);
    //校验用户手机
    TSso validatePhone(String phone);
    //用户登录
    Ret login(String username, String password);
}
