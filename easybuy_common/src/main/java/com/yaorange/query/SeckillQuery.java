package com.yaorange.query;

import java.io.Serializable;


public class SeckillQuery extends BaseQuery implements Serializable{
	private static final long serialVersionUID = -5897286036105915515L;
	//关键字 订单号 或 关键字
	private String keyword;
	//状态  -1代表全部
	private Byte state = -1;
	//年份 0代表最新三个月 其它代表所在年度
	private Integer year = 0;
	//是否评价
	private Integer isComment ;
	//是否进入退换货环节
	private Integer saleReturnState;
	//用户id
	private Long ssoId;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Byte getState() {
		return state;
	}
	public void setState(Byte state) {
		this.state = state;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getIsComment() {
		return isComment;
	}
	public void setIsComment(Integer isComment) {
		this.isComment = isComment;
	}
	public Long getSsoId() {
		return ssoId;
	}
	public void setSsoId(Long ssoId) {
		this.ssoId = ssoId;
	}
	public Integer getSaleReturnState() {
		return saleReturnState;
	}
	public void setSaleReturnState(Integer saleReturnState) {
		this.saleReturnState = saleReturnState;
	}
	
	
}
