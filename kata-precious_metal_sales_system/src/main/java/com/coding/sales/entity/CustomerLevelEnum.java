package com.coding.sales.entity;
/**
 * 用户等级枚举类CustomerLevelEnum
 * @author wanghao
 * @create 2019-07-02 16:25:21
 * @version 1.0
 */
public enum CustomerLevelEnum {
	LEVEL_1(1, 9999, "普卡"),
	LEVEL_2(2, 10000, "金卡"),
	LEVEL_3(3, 50000, "白金卡"),
	LEVEL_4(4, 100000, "钻石卡");
	
	private int code;
	
	private int points;
	
	private String message;
	
	private CustomerLevelEnum(int code, int points, String message) {
		this.code = code;
		this.points = points;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
