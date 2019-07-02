package com.coding.sales.entity;
/**
 * 用户等级枚举类CustomerLevelEnum
 * @author wanghao
 * @create 2019-07-02 16:25:21
 * @version 1.0
 */
public enum ProductCodeEnum {
	PRODUCT_1("001001"),
	PRODUCT_2("001002"),
	PRODUCT_3("003001"),
	PRODUCT_4("003002"),
	PRODUCT_5("002002"),
	PRODUCT_6("002001"),
	PRODUCT_7("002003");
	
	private String code;
	
	private ProductCodeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
