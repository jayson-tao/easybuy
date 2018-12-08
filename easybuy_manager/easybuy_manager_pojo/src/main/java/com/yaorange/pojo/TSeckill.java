package com.yaorange.pojo;

import java.io.Serializable;
import java.util.List;

public class TSeckill implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private String title;

    private Long beginTime;

    private Long endTime;

    private Byte state;

    private String description;

    private String activePic;

    //秒杀单品
    private List<TSeckillSku> skuList;

    public List<TSeckillSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<TSeckillSku> skuList) {
        this.skuList = skuList;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getActivePic() {
        return activePic;
    }

    public void setActivePic(String activePic) {
        this.activePic = activePic == null ? null : activePic.trim();
    }
}
