package com.coding.sales.entity;

import java.math.BigDecimal;
import java.util.List;
/**
 * 商品实体类Product
 * @author wanghao
 * @create 2019-07-02 16:18:21
 * @version 1.0
 */
public class Product {
	//产品编号
	private String productId;
	//产品名称
	private String productName;
	//产品单位
	private String productUnit;
	//产品价格
	private BigDecimal productPrice;
	//产品活动
	private List<Integer> productDiscount;
	
	public Product() {
		
	}
	
	public Product(String productId, String productName, String productUnit, BigDecimal productPrice,
			List<Integer> productDiscount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productUnit = productUnit;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public List<Integer> getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(List<Integer> productDiscount) {
		this.productDiscount = productDiscount;
	}
	
}
