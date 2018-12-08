package com.yaorange.controller;

import java.util.HashMap;
import java.util.Map;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取七牛云token
 */
@Controller
public class QiniuController {
    @RequestMapping("/go2Upload")
    public String go2Upload() {
        return "upload";
    }

    @RequestMapping("/plugin/qiniu/uptoken")
    @ResponseBody
    public Map<String, String> upToken() {
        String accessKey = "k2YDTmYW2_N2yI4msjJfzkIo9aMROxeO36E-gxS-";
        String secretKey = "f7eXd2-m3XboiB6v3Mr9YlsoF1Esou-2k90CnloN";
        //七牛云仓库
        String bucket = "javaqiniuyun";
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uptoken", upToken);
        return hashMap;
    }


}
