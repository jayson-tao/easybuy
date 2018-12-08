package com.yaorange.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.yaorange.consts.ICodes;
import com.yaorange.pojo.TSso;
import com.yaorange.util.RedisUtils;
import com.yaorange.util.Ret;
import com.yaorange.utils.SsoContext;

/**
 * 保护资源拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Value("${URL_CLIENT_LOGIN}")
    private String URL_CLIENT_LOGIN;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取被拦截url
        StringBuffer requestURL = request.getRequestURL();
        String to = request.getHeader("Referer");
        //从session中获取用户
        TSso sso = SsoContext.getSso();
        boolean isLogin = sso != null;
        //通过判断session中的用户是不是空判断用户是否登录
        //登录了
        if (isLogin) {
            String redisSsoId = RedisUtils.getRedisSsoId(sso.getId());
            //如果redis登录信息没有过期
            if (StringUtils.isNotEmpty(redisSsoId)) {
                //刷新过期时间
                RedisUtils.refreshRedisSsoId(sso.getId());
            } else {
                SsoContext.logOut();
                isLogin = false;
            }
        }
        // 如果用户没有登录
        if (!isLogin) {
            // 判断请求过来的地址是否是ajax请求
            String header = request.getHeader("X-Requested-With");
            boolean isAjax = "XMLHttpRequest".equalsIgnoreCase(header);
            //设置sso登录客户端的url
            String clientLogin = "/" + URL_CLIENT_LOGIN;
            if (!isAjax) {
                //如果不是ajax
                to = requestURL.toString();
                //设置url去哪里
                clientLogin += "?to=" + URLEncoder.encode(to, "utf-8");
                //重定向到sso登录客户端
                response.sendRedirect(clientLogin);
            } else {
                //如果是ajax
                clientLogin += "?to=" + URLEncoder.encode(to, "utf-8");
                //设置响应告诉浏览器重定向到sso客户端
                Ret ret = Ret.me().setSuccess(false).setCode(ICodes.UNAUTHED).setData(clientLogin);
                String retJson = JSON.toJSONString(ret);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(retJson);
                response.getWriter().flush();
                response.getWriter().close();
            }
        }
        return isLogin;
    }

}
