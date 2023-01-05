package com.jbk.product.utility;

import java.util.Scanner;

import com.jbk.product.entity.Product;

public class ProductUtility {
	
	public static Product prepareProductData(Scanner scanner) {
		
		System.out.println("Enter product id :");
		int productId=scanner.nextInt();
		
		System.out.println("Enter product name :");
		String productName=scanner.next();
		
		System.out.println("Enter product price :");
		double productPrice=scanner.nextDouble();
		
		System.out.println("Enter product mfg :");
		String productMfg=scanner.next();
		
		System.out.println("Enter product category :");
		String productCategory=scanner.next();
		
		Product product= new Product(productId, productName, productPrice, productMfg, productCategory);
		
		return product;
	}

}
