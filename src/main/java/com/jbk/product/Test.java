package com.jbk.product;

import java.util.List;
import java.util.Scanner;

import com.jbk.product.entity.Product;
import com.jbk.product.service.ProductService;
import com.jbk.product.utility.ProductUtility;

public class Test {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ProductService service=new ProductService();
		
		int choice;
		char ch;
		do {
			System.out.println("****** controller ******");
			System.out.println("Press 1 for Save Product.");
			System.out.println("Press 2 for Get product.");
			System.out.println("Press 3 for Delete product.");
			System.out.println("Press 4 for update product.");
			System.out.println("Press 5 for All product.");
			System.out.println("Press 6 for All product by Descending .");
			System.out.println("Press 7 for All product by Ascending .");
			System.out.println("Press 8 for All product in Between .");
			System.out.println("Press 9 for All product in Restriction");
			
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1: {
				Product product = ProductUtility.prepareProductData(scanner);
				String msg = service.saveProduct(product);
				System.out.println(msg);
				break;
			}
			
            case 2: {
            	System.out.println("Enter Product Id .");
				int productId = scanner.nextInt();
				Product product = service.getProductById(productId);
				if (product!=null) {
					
					System.out.println(product);
					}else {
						System.out.println("Product not found.");
					}
				
				break;
				
            }	
				
            case 3: {
				System.out.println("Enter product id :");
				int productid=scanner.nextInt();
				String msg = service.deleteProductById(productid);
				System.out.println(msg);
				break;
			
            }	
            
            case 4:{
            	Product product=ProductUtility.prepareProductData(scanner);
            	String msg=service.updatedProduct(product);
            	System.out.println(msg);
                break;
            }
            
            case 5:{ 
            	
            	List<Product> list = service.getAllProducts();
            	if (!list.isEmpty()) {
            		
            		for (Product product : list) {
            			
            			System.out.println(product);
						
					}
					
				}
            	else {
					System.out.println("Product not exits !!");
				}
            	
            	break;
            }
            
            case 6:{
            	
            	List<Product> list = service.getAllProductsDesc();
            	if (!list.isEmpty()) {
            		
            		for (Product product : list) {
            			
            			System.out.println(product);
						
					}
					
				}
            	else {
					System.out.println("Product not exits !!");
				}
            	
            	break;
            }
            
                case 7:{
            	
            	List<Product> list = service.getAllProductsAsc();
            	if (!list.isEmpty()) {
            		
            		for (Product product : list) {
            			
            			System.out.println(product);
						
					}
					
				}
            	else {
					System.out.println("Product not exits !!");
				}
            	
            	break;
            }
                
                case 8:{
                	
                	List<Product> list = service.getAllProductsBetween();
                	if (!list.isEmpty()) {
                		
                		for (Product product : list) {
                			
                			System.out.println(product);
    						
    					}
    					
    				}
                	else {
    					System.out.println("Product not exits !!");
    				}
                	
                	break;
                }
                
                case 9:{
                	
                	List<Product> list = service.restrictionsEx();
                	
                        if (!list.isEmpty()) {
                		
                		for (Product product : list) {
                			
                			System.out.println(product);
    						
    					}
    					
    				}
                	else {
    					System.out.println("Product not exits !!");
    				}
                	
                	break;
                }


			default:
				
				System.out.println("Invalid choice .");
				
	           break;
				
			}
			
			System.out.println("Do you want to continue y/n ?");
			ch = scanner.next().charAt(0);
			
		} while (ch=='y' || ch=='Y');
		
		System.out.println("Terminated .");
	}

}
