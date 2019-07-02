package com.coding.sales.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.coding.sales.entity.DiscountTypeEnum;
import com.coding.sales.entity.Product;
import com.coding.sales.service.ProductSaleService;

/**
 * @author wsk
 * @Date 2019年7月2日 下午5:05:27
 */
public class ProductSaleServiceImpl implements ProductSaleService {

	@Override
	public BigDecimal sales(Product product, BigDecimal amount, List<Integer> discountsList) {
		BigDecimal priceDecimal = product.getProductPrice();
		BigDecimal totalAmBigDecimal = priceDecimal.multiply(amount);
		BigDecimal totalAmount = BigDecimal.ZERO;
		System.out.println(discountsList);
		if(discountsList != null && discountsList.size() > 0){
			for(Integer num : discountsList){
				if(DiscountTypeEnum.ACTIVITY_5.getCode() == num && amount.intValue() >= 4){
					totalAmount = priceDecimal.multiply(amount.subtract(new BigDecimal(1)));
					break;
				}else if(DiscountTypeEnum.ACTIVITY_4.getCode() == num && amount.intValue() >= 3){
					totalAmount = priceDecimal.multiply(amount.subtract(new BigDecimal(0.5)));
					break;
				}else if(DiscountTypeEnum.ACTIVITY_1.getCode() == num && totalAmBigDecimal.intValue() >= 3000){
					totalAmount = totalAmBigDecimal.subtract(new BigDecimal(350));
					break;
				}else if(DiscountTypeEnum.ACTIVITY_2.getCode() == num && totalAmBigDecimal.intValue() >= 2000){
					totalAmount = totalAmBigDecimal.subtract(new BigDecimal(30));
					break;
				}else if(DiscountTypeEnum.ACTIVITY_3.getCode() == num && totalAmBigDecimal.intValue() >= 1000){
					totalAmount = totalAmBigDecimal.subtract(new BigDecimal(10));
					break;
				}
			}
			
			for(Integer num : discountsList){
				if(DiscountTypeEnum.DISCOUNT_90.getCode() == num){
					totalAmount = totalAmount.multiply(new BigDecimal(0.9));
				}else if(DiscountTypeEnum.DISCOUNT_95.getCode() == num){
					totalAmount = totalAmount.multiply(new BigDecimal(0.95));
				}
			}
		}
		else {
			totalAmount = totalAmBigDecimal;
		}
		
		return totalAmount;
	}
}
