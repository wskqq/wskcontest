package com.coding.sales;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.coding.sales.database.CustomerInfo;
import com.coding.sales.database.ProductInfo;
import com.coding.sales.entity.Customer;
import com.coding.sales.entity.CustomerLevelEnum;
import com.coding.sales.entity.Product;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.service.ProductSaleService;
import com.coding.sales.service.impl.ProductSaleServiceImpl;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
//        if (args.length != 2) {
//            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
//        }

//        String jsonFileName = args[0];
//        String txtFileName = args[1];
        String jsonFileName = "sample_command.json";
        String txtFileName = "sample_result.txt";    	

        String orderCommand = FileUtils.readFromFile(OrderApp.class.getResource("sample_command.json").getPath());
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);
        System.out.println(result.toString());
        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;
        //商品信息
        Product product = null;

        //获取商品信息列表
        ProductInfo productInfo = new ProductInfo();
        Map<String, Product> productInfoMap = productInfo.initProductInfo();
        List<Integer> productDiscount = null;
        //商品数量
        Integer productAmount = 0;
        
        List<OrderItemCommand> productList = command.getItems();
        ProductSaleService productSaleService = new ProductSaleServiceImpl();
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
        //未优惠金额
        BigDecimal totalAmountSum = BigDecimal.ZERO;
        //遍历商品列表
        for(OrderItemCommand orderItemCommand : productList){
        	//获取商品
        	product = productInfoMap.get(orderItemCommand.getProduct());
        	//获取商品活动
        	if(productDiscount != null)
        	productDiscount = product.getProductDiscount();
        	BigDecimal amount = orderItemCommand.getAmount();
        	
        	BigDecimal totalDecimal = productSaleService.sales(product, amount, productDiscount);
        	totalAmount = totalAmount.add(totalDecimal);
        	totalAmountSum = product.getProductPrice().multiply(amount).add(totalAmountSum);
        	OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(String.valueOf(product.getProductId()), product.getProductName(), product.getProductPrice(), amount, product.getProductPrice().multiply(amount));
        }
        
        String memberId = command.getMemberId();
        CustomerInfo customerInfo = new CustomerInfo();
        Map<String,Customer> customerMap = customerInfo.initCustomerInfo();
        Customer customer = customerMap.get(memberId);
        Integer customerLevel = customer.getCustomerLevel();
        Integer customerPoints = customer.getCustomerPoints();
        Integer newAddPoints = 0;
        String oldMemberType = "";
        String newMemberType = "";
        if(CustomerLevelEnum.LEVEL_1.equals(customerLevel)){
        	oldMemberType = CustomerLevelEnum.LEVEL_1.getMessage();
        	newAddPoints = totalAmount.intValue();
        	customerPoints = customerPoints + newAddPoints;
        	if(customerPoints > CustomerLevelEnum.LEVEL_4.getPoints()){
        		newMemberType = CustomerLevelEnum.LEVEL_4.getMessage();
        	}else if(customerPoints > CustomerLevelEnum.LEVEL_3.getPoints()){
        		newMemberType = CustomerLevelEnum.LEVEL_3.getMessage();
        	}else if(customerPoints > CustomerLevelEnum.LEVEL_2.getPoints()){
        		newMemberType = CustomerLevelEnum.LEVEL_2.getMessage();
        	}
        }else if(CustomerLevelEnum.LEVEL_2.equals(customerLevel)){
        	oldMemberType = CustomerLevelEnum.LEVEL_2.getMessage();
        	newAddPoints = totalAmount.multiply(new BigDecimal(1.5)).intValue();
        	customerPoints = customerPoints + newAddPoints;
        	if(customerPoints > CustomerLevelEnum.LEVEL_4.getPoints()){
        		newMemberType = CustomerLevelEnum.LEVEL_4.getMessage();
        	}else if(customerPoints > CustomerLevelEnum.LEVEL_3.getPoints()){
        		newMemberType = CustomerLevelEnum.LEVEL_3.getMessage();
        	}        	
        }else if(CustomerLevelEnum.LEVEL_3.equals(customerLevel)){
        	oldMemberType = CustomerLevelEnum.LEVEL_3.getMessage();
        	newAddPoints = totalAmount.multiply(new BigDecimal(1.8)).intValue();
        	customerPoints = customerPoints + newAddPoints;
        	if(customerPoints > CustomerLevelEnum.LEVEL_4.getPoints()){
        		newMemberType = CustomerLevelEnum.LEVEL_4.getMessage();
        	}
        }else if(CustomerLevelEnum.LEVEL_4.equals(customerLevel)){
        	newAddPoints = totalAmount.multiply(new BigDecimal(2)).intValue();
        	customerPoints = customerPoints + newAddPoints;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
        String orderId = sdf.format(new Date());
        
        result = new OrderRepresentation(orderId, new Date(), memberId, customer.getCustomerName(), oldMemberType,
        		newMemberType, newAddPoints, customerPoints, orderItems, totalAmountSum, null, null,
        		totalAmount, null, null);
        return result;
    }
}
