package com.yaorange.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaorange.pojo.TSso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaorange.consts.msg.MsgConst;
import com.yaorange.service.UserService;
import com.yaorange.util.Ret;
import com.yaorange.util.ValidateCode;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/regist")

public class RegistController {
    @Autowired
    private UserService userService;
    @Autowired
    private JedisPool jedisPool;

    /**
     * 图形验证码页面
     *
     * @return
     */
    @RequestMapping(value = "/captcha")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ValidateCode vCode = new ValidateCode(130, 40, 5, 100);
        //把验证码放在session中
        // session.setAttribute("captcha", vCode.getCode());
        //把验证码放在session中
        Jedis resource = jedisPool.getResource();
        resource.set("captcha", vCode.getCode());
        resource.pexpire("captcha",MsgConst.SMS_CODE_VALID_SECONDS*1000);
        vCode.write(response.getOutputStream());
        resource.close();
    }

    /**
     * 校验电话号码是否已注册
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/validatePhone")
    @ResponseBody
    public Ret validatePhone(String phone) {
        TSso sso = userService.validatePhone(phone);
        if (sso != null) {
            //如果有记录说明已经注册
            return Ret.me().setCode(MsgConst.PHONE_NUMBER_EXISTS);
        }
        return Ret.me();

    }

    /**
     * 发送验证码
     */
    @RequestMapping("/sendSmsCode")
    @ResponseBody
    public Ret sendSmsCode(String phone, HttpSession session) {
        userService.sendSmsCode(phone, session);
        return Ret.me();
    }

    /**
     * 保存注册用户信息
     *
     * @param phone
     * @param captcha    验证码
     * @param password
     * @param smsCaptcha 短信验证码
     */
    @RequestMapping("/reg/phone")
    @ResponseBody
    public Ret regPhone(String phone, String captcha, String password, String smsCaptcha, HttpSession session) {
        Ret ret = userService.saveByregPhone(phone, captcha, password, smsCaptcha, session);
        return ret;
    }


}
