package com.coding.sales.service;

import java.math.BigDecimal;
import java.util.List;

import com.coding.sales.entity.Product;

/**
 * @author wsk
 * @Date 2019年7月2日 下午5:01:28
 */
public interface ProductSaleService {
	BigDecimal sales(Product product,BigDecimal amount,List<Integer> discountsList);
}
