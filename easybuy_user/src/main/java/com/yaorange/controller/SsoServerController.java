package com.yaorange.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaorange.consts.msg.MsgConst;
import com.yaorange.pojo.TSso;
import com.yaorange.service.UserService;
import com.yaorange.util.RedisUtils;
import com.yaorange.util.Ret;
import com.yaorange.util.ValidateCode;

/**
 * sso服务端
 */
@Controller
public class SsoServerController {
    @Value("${URL_PROTAL}")
    private String URL_PROTAL;
    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     */
    @RequestMapping("/login/passport/in")
    @ResponseBody
    public Ret loginByPasswd(String username, String password, HttpServletResponse response) {
        Ret ret = userService.login(username, password);
        //如果登录成功
        // 生成tgc通过ssoId和随机串组合的MD5值作为tgc的值，然后通过tgc作为key存入redis缓存，对应的值(tgt)为ssoId即可
        //  将tgc写入cookie 浏览器会话期
        // 有效
        //  将单点登录用户ID写入redis
        if (ret.isSuccess()) {
            //获取用户信息
            TSso sso = (TSso) ret.getData();
            // 1.把用户ID写入redis key ->u-ssoid value->ssoid
            RedisUtils.setRedisSsoId(sso.getId());
            // 2.生成tgc ssoid->tgc
            String tgc = RedisUtils.getSsoTGC(sso.getId() + "");
            // 3.将tgc写入到cookie中
            Cookie cookie = new Cookie("tgc", tgc);
            cookie.setPath("/");
            response.addCookie(cookie);
            // 4.通过tgc生成st
            String st = RedisUtils.getSsoST(tgc);
            ret.setData(st);
        }
        return ret;
    }

    /**
     * sso服务端登录接口
     */
    @RequestMapping("/login")
    public String login(String from, String to, Integer relogin, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String tgc = "";
        //获取cookei的tgc --判断cookie是否有效
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tgc")) {
                    tgc = cookie.getValue();
                    if (relogin != null && relogin == 1) {
                        // 删除tgc
                        RedisUtils.deleteSsoTGC(tgc);
                        // 重置tgc并删除cookie
                        tgc = "";
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
        }
        if (StringUtils.isNotBlank(tgc)) {
            //判断tgc是否有效--redis有效
            boolean validateSsoTGC = RedisUtils.validateSsoTGC(tgc);
            //有效
            if (validateSsoTGC) {
                // 获取票据
                String st = RedisUtils.getSsoST(tgc);
                // 刷新tgc过期时间
                RedisUtils.refreshTGCExpires(tgc);
                // 返回票据给调用者
                response.sendRedirect(from + "?st=" + st + "&to=" + URLEncoder.encode(to, "utf-8"));
                return null;
            }
        }
        // 需要登录
        response.sendRedirect("/login.html?wwwurl=" + URL_PROTAL + "&from=" + from + "&to=" + URLEncoder.encode(to, "utf-8"));
        return null;
    }

}
