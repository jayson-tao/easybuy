package com.yaorange.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.yaorange.pojo.TSsoExample;
import com.yaorange.util.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.yaorange.consts.bis.RegChannelConsts;
import com.yaorange.consts.msg.MsgConst;
import com.yaorange.mapper.TPayAccountMapper;
import com.yaorange.mapper.TSsoMapper;
import com.yaorange.mapper.TVipBaseMapper;
import com.yaorange.pojo.TPayAccount;
import com.yaorange.pojo.TSso;
import com.yaorange.pojo.TVipBase;
import com.yaorange.service.UserService;
import com.yaorange.util.BitStatesUtils;
import com.yaorange.util.StrUtils;
import com.yaorange.util.encrypt.MD5;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Value("${CLOOPEN_ACCOUNT_SID}")
    private String CLOOPEN_ACCOUNT_SID;
    @Value("${CLOOPEN_ACCOUNT_TOKEN}")
    private String CLOOPEN_ACCOUNT_TOKEN;
    @Value("${CLOOPEN_APP_ID}")
    private String CLOOPEN_APP_ID;
    @Value("${CLOOPEN_SMS_CODE_TEMPALTE_ID}")
    private String CLOOPEN_SMS_CODE_TEMPALTE_ID;

    @Autowired
    private TSsoMapper ssoMapper;
    @Autowired
    private TVipBaseMapper vipBaseMapper;
    @Autowired
    private TPayAccountMapper payAccountMapper;
    //注入一个jedisPool连接池
    @Autowired
    private JedisPool jedisPool;

    /**
     * 发送短信验证码
     *
     * @param phone
     * @param session
     */
    @Override
    public void sendSmsCode(String phone, HttpSession session) {
        HashMap<String, Object> result = null;
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        restAPI.init("app.cloopen.com", "8883");
        restAPI.setAccount(CLOOPEN_ACCOUNT_SID, CLOOPEN_ACCOUNT_TOKEN);
        restAPI.setAppId(CLOOPEN_APP_ID);
        //生成四位随机数
        String smsCode = StrUtils.getRandomString(4);
        int mintues = MsgConst.SMS_CODE_VALID_SECONDS / 60;
        result = restAPI.sendTemplateSMS(phone, CLOOPEN_SMS_CODE_TEMPALTE_ID, new String[]{smsCode, "" + mintues});
        System.out.println("SDKTestGetSubAccounts result=" + result);
        if ("000000".equals(result.get("statusCode"))) {
            // 正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            // 异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
        //发送成功吧验证码保存在session中
        //session.setAttribute("smsCode", smsCode);
        //设置过期时间
        //session.setMaxInactiveInterval(MsgConst.SMS_CODE_VALID_SECONDS);
        //把验证码保存在redis中
        Jedis resource = jedisPool.getResource();
        resource.set("smsCode", smsCode);
        resource.pexpire("smsCode", MsgConst.SMS_CODE_VALID_SECONDS * 1000);
        resource.close();
    }

    /**
     * 用户登录
     *
     * @param username 手机号
     * @param password
     */
    @Override
    public Ret login(String username, String password) {
        Ret me = Ret.me();
        TSsoExample example = new TSsoExample();
        example.createCriteria().andPhoneEqualTo(username);
        List<TSso> ssos = ssoMapper.selectByExample(example);
        if (ssos != null && ssos.size() > 0) {
            //数据库有数据
            TSso sso = ssos.get(0);
            //如果密码正确
            if (sso.getPassword().equals(MD5.getMD5(password + sso.getSalt()))) {
                return me.setData(sso);
            }
        }
        //用户名或密码错误
        return me.setSuccess(false).setCode(MsgConst.INVALIDE_USER_PASSWORD);
    }

    /**
     * 校验使用手机是否注册
     *
     * @param phone
     */
    @Override
    public TSso validatePhone(String phone) {
        TSsoExample example = new TSsoExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<TSso> ssos = ssoMapper.selectByExample(example);
        if (ssos != null && ssos.size() > 0) {
            //如果有记录说明已经注册了
            return ssos.get(0);
        }
        return null;
    }

    /**
     * 保存注册用户信息
     *
     * @param phone
     * @param captcha    验证码
     * @param password
     * @param smsCaptcha 短信验证码
     */
    @Override
    public Ret saveByregPhone(String phone, String captcha, String password, String smsCaptcha, HttpSession session) {
        //判断captcha和smsCaptcha是否和页面或者发送短信内容一样
        Ret me = Ret.me();
        //图片验证码
        // String captcha1 = (String) session.getAttribute("captcha");
        //从redis获取信息
        Jedis resource = jedisPool.getResource();
        String captcha1 = resource.get("captcha");
        if (!captcha1.equalsIgnoreCase(captcha)) {
            //如果验证码不正确
            me.setCode(MsgConst.INVALIDE_CAPTCHA);
            return me;
        }

        //获取短信验证码
        // String smsCode = (String) session.getAttribute("smsCode");
        String smsCode = resource.get("smsCode");
        resource.close();
        if (!smsCode.equalsIgnoreCase(smsCaptcha)) {
            me.setCode(MsgConst.SMS_CODE_INVALIDE);
            return me;
        }
        //保存sso
        TSso sso = new TSso();
        sso.setCreateTime(System.currentTimeMillis());
        sso.setUpdateTime(System.currentTimeMillis());
        sso.setNickName(phone);
        sso.setPhone(phone);
        String salt = StrUtils.getComplexRandomString(32);
        //设置盐
        sso.setSalt(salt);
        String md5 = MD5.getMD5(password + salt);
        sso.setPassword(md5);
        long bitState = BitStatesUtils.OP_REGISTED;
        sso.setBitState(bitState);
        ssoMapper.insert(sso);

        // 同步创建用户基本资料记录
        TVipBase vipBase = new TVipBase();
        vipBase.setActiveTime(System.currentTimeMillis());
        vipBase.setActiveType(RegChannelConsts.PHONE);
        vipBase.setCreateTime(System.currentTimeMillis());
        vipBase.setUpdateTime(System.currentTimeMillis());
        vipBase.setGrowScore(1);
        vipBase.setRegChannel(RegChannelConsts.PHONE);
        vipBase.setRegTime(sso.getCreateTime());
        vipBase.setSsoId(sso.getId());
        vipBaseMapper.insert(vipBase);

        // 同步创建用户账户信息
        TPayAccount payAccount = new TPayAccount();
        payAccount.setCouponCount(0);
        payAccount.setCreateTime(System.currentTimeMillis());
        payAccount.setUpdateTime(System.currentTimeMillis());
        payAccount.setCreditBanance(0);
        payAccount.setFrozenBalance(0);
        payAccount.setPayPassword(sso.getPassword());
        payAccount.setSsoId(sso.getId());
        payAccount.setUseableBalance(0);
        payAccountMapper.insert(payAccount);
        return me;
    }

}
