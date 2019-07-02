package com.coding.sales.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.sales.entity.Product;
/**
 * 商品信息加载类ProductInfo
 * @author wanghao
 * @create 2019-07-02 17:10:21
 * @version 1.0
 */
public class ProductInfo {
	public Map<String, Product> initProductInfo(){
		
		//商品信息
		Map<String, Product> productMap = new HashMap<String, Product>();
		
		//产品折扣列表
		List<Integer> product1Discount = new ArrayList<Integer>();
		List<Integer> product2Discount = new ArrayList<Integer>();
		product2Discount.add(2);
		List<Integer> product3Discount = new ArrayList<Integer>();
		product3Discount.add(1);
		List<Integer> product4Discount = new ArrayList<Integer>();
		product4Discount.add(6);
		product4Discount.add(7);
		List<Integer> product5Discount = new ArrayList<Integer>();
		product5Discount.add(4);
		product5Discount.add(5);
		List<Integer> product6Discount = new ArrayList<Integer>();
		product6Discount.add(1);
		product6Discount.add(6);
		product6Discount.add(7);
		List<Integer> product7Discount = new ArrayList<Integer>();
		product7Discount.add(3);
		product7Discount.add(4);
		product7Discount.add(5);
		product7Discount.add(2);
		
		/****产品信息*******************产品编号******产品名称*********************产品单位*******产品价格********************产品活动*****/
		Product product1 = new Product("001001", "世园会五十国钱币册",				"册",	new BigDecimal("998.00"),	product1Discount);
		Product product2 = new Product("001002", "2019北京世园会纪念银章大全40g",		"盒",	new BigDecimal("1380.00"),	product2Discount);
		Product product3 = new Product("003001", "招财进宝",						"条",	new BigDecimal("1580.00"),	product3Discount);
		Product product4 = new Product("003002", "水晶之恋",						"条",	new BigDecimal("980.00"),	product4Discount);
		Product product5 = new Product("002002", "中国经典钱币套装",					"套",	new BigDecimal("998.00"),	product5Discount);
		Product product6 = new Product("002001", "守扩之羽比翼双飞4.8g",				"条",	new BigDecimal("1080.00"),	product6Discount);
		Product product7 = new Product("002003", "中国银象棋12g",					"套",	new BigDecimal("698.00"),	product7Discount);
		
		productMap.put(String.valueOf(product1.getProductId()), product1);
		productMap.put(String.valueOf(product2.getProductId()), product2);
		productMap.put(String.valueOf(product3.getProductId()), product3);
		productMap.put(String.valueOf(product4.getProductId()), product4);
		productMap.put(String.valueOf(product5.getProductId()), product5);
		productMap.put(String.valueOf(product6.getProductId()), product6);
		productMap.put(String.valueOf(product7.getProductId()), product7);
		
		return productMap;
	}
}
