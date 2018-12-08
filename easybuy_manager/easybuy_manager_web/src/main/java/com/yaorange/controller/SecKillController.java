package com.yaorange.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.yaorange.consts.ControllerConsts;
import com.yaorange.pojo.TSeckill;
import com.yaorange.pojo.TSeckillSku;
import com.yaorange.pojo.TSku;
import com.yaorange.service.SecKillService;
import com.yaorange.service.SkuService;
import com.yaorange.util.Page;
import com.yaorange.util.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.plaf.ProgressBarUI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller
@RequestMapping("/"+SecKillController.DOMAIN)
public class SecKillController {
    public static final String DOMAIN = "snapup";

    @Autowired
    private SecKillService secKillService;
    @Autowired
    private SkuService skuService;

    /**
     * 首页
     */
    @RequestMapping(value = ControllerConsts.URL_INDEX, method = RequestMethod.GET)
    public String index() {
        return DOMAIN + ControllerConsts.VIEW_INDEX;
    }

    /**
     * 编辑/添加页面
     */
    @RequestMapping(value = ControllerConsts.URL_EDIT, method = RequestMethod.GET)
    public String edit(Long id, Model model) {
        if(id!=null){
            //编辑页面 回显秒杀活动
            secKillService.echo(id,model);
        }
        return DOMAIN + ControllerConsts.VIEW_EDIT;
    }

    /**
     * 分页
     */
    @RequestMapping(value = ControllerConsts.URL_JSON, method = RequestMethod.GET)
    @ResponseBody
    public Page<TSeckill> findByPage(Integer page, Integer rows) {
        Page<TSeckill> seckillPage = secKillService.getSeckillPage(page, rows);
        return seckillPage;
    }

    @RequestMapping(ControllerConsts.URL_STORE)
    @ResponseBody
    public Ret store(TSeckill seckill,String skuDatas,String beginTimeFormat,String endTimeFormat) throws Exception{
        String[] secKillSkus = skuDatas.split(":::");
        ArrayList<TSeckillSku> skuList = new ArrayList<>();

        //秒杀单品的 拼装
        for (String secKillSku : secKillSkus) {
            String[] skuParts = secKillSku.split("::");
            TSeckillSku sku = new TSeckillSku();
            sku.setCreateTime(System.currentTimeMillis());
            sku.setUpdateTime(sku.getCreateTime());
            sku.setSkuId(Long.parseLong(skuParts[0]));
            sku.setProductId(Long.parseLong(skuParts[1]));
            sku.setSkuPic(skuParts[2]);
            sku.setSkuName(skuParts[3]);
            sku.setPrice(Integer.parseInt(skuParts[4]));
            sku.setTotalCount(Integer.parseInt(skuParts[5]));
            sku.setLeftCount(Integer.parseInt(skuParts[5]));
            skuList.add(sku);
        }
        //秒杀单品放到秒杀活动中
        seckill.setSkuList(skuList);
        //2018-12-05 09:52:12
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        seckill.setBeginTime(sdf.parse(beginTimeFormat).getTime());
        seckill.setEndTime (sdf.parse(endTimeFormat).getTime());
        secKillService.saveSecKill(seckill);
        return Ret.me();
    }

    /**
     * 根据sku code获取sku信息
     */
    @RequestMapping("/getSku")
    @ResponseBody
    public TSku getSku(String skuCode) {
        return skuService.getSkuByCode(skuCode);
    }

    /**
     * 秒杀活动的发布
     * @param secKillId 秒杀活动id
     */
    @RequestMapping("/publish")
    @ResponseBody
    public Ret publish(long secKillId) {
        secKillService.updateSecKill(secKillId);
        return Ret.me();
    }

}
