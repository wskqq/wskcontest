package com.coding.sales.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.sales.entity.Customer;
/**
 * 用户信息加载类CustomerInfo
 * @author wanghao
 * @create 2019-07-02 17:20:21
 * @version 1.0
 */
public class CustomerInfo {
	public Map<String, Customer> initCustomerInfo(){
		
		//用户信息
		Map<String, Customer> customerMap = new HashMap<String, Customer>();
		
		//用户优惠券列表
		List<Integer> customer1Discount = new ArrayList<Integer>();
		customer1Discount.add(1);
		List<Integer> customer2Discount = new ArrayList<Integer>();
		customer2Discount.add(2);
		customer2Discount.add(3);
		List<Integer> customer3Discount = new ArrayList<Integer>();
		customer3Discount.add(4);
		customer3Discount.add(5);
		List<Integer> customer4Discount = new ArrayList<Integer>();
		customer4Discount.add(1);
		customer4Discount.add(3);
		customer4Discount.add(5);
		customer4Discount.add(7);
		
		/*****用户信息*******************用户id**用户姓名*****用户账号****用户等级***用户积分*****用户优惠券******/
		Customer customer1 = new Customer(1L,	 "马丁",	 "6236609999",	 1,		 9860,	 customer1Discount);
		Customer customer2 = new Customer(2L,	 "马丁",	 "6630009999",	 1,		 9860,	 customer1Discount);
		Customer customer3 = new Customer(3L,	 "马丁",	 "8230009999",	 1,		 9860,	 customer1Discount);
		Customer customer4 = new Customer(4L,	 "马丁",	 "9230009999",	 1,		 9860,	 customer1Discount);
		
		customerMap.put(String.valueOf(customer1.getCustomerAccount()), customer1);
		customerMap.put(String.valueOf(customer2.getCustomerAccount()), customer2);
		customerMap.put(String.valueOf(customer3.getCustomerAccount()), customer3);
		customerMap.put(String.valueOf(customer4.getCustomerAccount()), customer4);
		
		return customerMap;
	}
}
