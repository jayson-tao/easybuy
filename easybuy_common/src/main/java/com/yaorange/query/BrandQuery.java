package com.yaorange.query;

import java.io.Serializable;


public class BrandQuery extends BaseQuery implements Serializable{
	private static final long serialVersionUID = 8007353887131487337L;
	private Long productType;
	private String keyword;
	public Long getProductType() {
		return productType;
	}
	public void setProductType(Long productType) {
		this.productType = productType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
