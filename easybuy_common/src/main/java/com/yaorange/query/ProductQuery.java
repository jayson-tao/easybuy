package com.yaorange.query;

import java.io.Serializable;
import java.util.Date;



public class ProductQuery extends BaseQuery implements Serializable {
	private static final long serialVersionUID = 7625932278067195253L;
	// 排序方式常量
	public static final String ORDER_ZH = "s";
	public static final String ORDER_XL = "xl";
	public static final String ORDER_XP = "xp";
	public static final String ORDER_PL = "pl";
	public static final String ORDER_JG = "jg";
	public static final String ORDER_RQ = "rq";

	private String keyword;
	private Long productType;
	private Long brand;
	private Integer priceMin;
	private Integer priceMax;
	private Date startDate;
	private Date endDate;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getProductType() {
		return productType;
	}

	public void setProductType(Long productType) {
		this.productType = productType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Long getStartDateMills() {
		return startDate.getTime();
	}

	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Long getEndDateMills() {
		return endDate.getTime();
	}

	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public Integer getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}

	public Integer getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}
}
