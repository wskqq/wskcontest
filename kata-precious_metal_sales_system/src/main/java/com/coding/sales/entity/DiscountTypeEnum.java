package com.coding.sales.entity;
/**
 * 折扣及活动优惠枚举类DiscountTypeEnum
 * @author wanghao
 * @create 2019-07-02 16:15:21
 * @version 1.0
 */
public enum DiscountTypeEnum {
	DISCOUNT_95(1, "95折"),
	DISCOUNT_90(2, "9折"),
	ACTIVITY_1(3,"每满3000元减350"),
	ACTIVITY_2(4,"每满2000元减30"),
	ACTIVITY_3(5,"每满1000元减10"),
	ACTIVITY_4(6,"第3件半价"),
	ACTIVITY_5(7,"满3送1");
	
	private int code;
	
	private String message;
	
	private DiscountTypeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
