package com.yaorange.controller;

import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaorange.mapper.TSsoMapper;
import com.yaorange.pojo.TSso;
import com.yaorange.util.RedisUtils;
import com.yaorange.utils.SsoContext;

/**
 * 单点登录sso客户端登录
 */
@Controller
@RequestMapping("/client")
public class SsoClientController {
    @Autowired
    private TSsoMapper ssoMapper;
    //sso服务端登录接口
    @Value("${URL_SERVER_LOGIN}")
    private String URL_SERVER_LOGIN;
    //sso服务端注册接口
    @Value("${URL_SERVER_REG}")
    private String URL_SERVER_REG;
    //sso服务端退出登录接口
    @Value("${URL_SERVER_LOGOUT}")
    private String URL_SERVER_LOGOUT;
    //sso客户端登录接口
    @Value("${URL_CLIENT_LOGIN}")
    private String URL_CLIENT_LOGIN;
    //受保护资源域名
    @Value("${URL_PROTAL}")
    private String URL_PROTAL;

    /**
     * 单点登录sso客户端
     * @param st 访问票据 根据票据来判断用户是否登录
     * @param to 请求来至那个uri 等下要返回到哪里
     */
    @RequestMapping("/login")
    public String login(String st, String to) throws Exception {
        String redirectUrl = "";
        String fromUrl = URL_PROTAL + URL_CLIENT_LOGIN;
        // 如果没有访问票据
        if (StringUtils.isBlank(st)) {
            //请求sso服务端登录接口
            redirectUrl = URL_SERVER_LOGIN + "?from=" + fromUrl + "&to=" + URLEncoder.encode(to, "utf-8");
        } else {
            String ssoId = RedisUtils.validateSsoST(st);
            // 票据有效
            if (StringUtils.isNotEmpty(ssoId)) {
                //把登录用户放到session中
                TSso sso = ssoMapper.selectByPrimaryKey(Long.parseLong(ssoId));
                SsoContext.setSso(sso);
                redirectUrl = to;
            }
            // 票据无效-->跳转sso服务端登录接口
            else {
                redirectUrl = URL_SERVER_LOGIN + "?relogin=1&from=" + fromUrl + "&to=" + URLEncoder.encode(to, "utf-8");
            }
        }
        return "redirect:" + redirectUrl;
    }

}
