package com.coding.sales.entity;

import java.util.List;
/**
 * 用户实体类Customer
 * @author wanghao
 * @create 2019-07-02 16:10:21
 * @version 1.0
 */
public class Customer {
	//用户id
	private Long customerId;
	//用户姓名
	private String customerName;
	//用户账号
	private String customerAccount;
	//用户等级
	private Integer customerLevel;
	//用户积分
	private Integer customerPoints;
	//用户优惠券
	private List<Integer> customerDiscount;
	
	public Customer() {
		
	}
	
	public Customer(Long customerId, String customerName, String customerAccount, Integer customerLevel,
			Integer customerPoints, List<Integer> customerDiscount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAccount = customerAccount;
		this.customerLevel = customerLevel;
		this.customerPoints = customerPoints;
		this.customerDiscount = customerDiscount;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}
	public Integer getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}
	public Integer getCustomerPoints() {
		return customerPoints;
	}
	public void setCustomerPoints(Integer customerPoints) {
		this.customerPoints = customerPoints;
	}
	public List<Integer> getCustomerDiscount() {
		return customerDiscount;
	}
	public void setCustomerDiscount(List<Integer> customerDiscount) {
		this.customerDiscount = customerDiscount;
	}
}
