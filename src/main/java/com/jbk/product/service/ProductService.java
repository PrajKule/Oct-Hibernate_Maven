package com.jbk.product.service;

import java.util.List;

import com.jbk.product.dao.ProductDao;
import com.jbk.product.entity.Product;

public class ProductService {
	
	private ProductDao dao= new ProductDao();
	
	public String saveProduct(Product product){
		
		String msg=dao.saveProduct(product);
		
		return msg;
		
	}
	
	public Product getProductById( int productId) {
		
		
		return dao.getProductById(productId);
		
		
	}
	
	public String deleteProductById(int productId) {
		
		return dao.deleteProductById(productId);
		
	}
	
	public String updatedProduct(Product product) {
		
		return dao.updatedProduct(product);
	}
	
	public List<Product> getAllProducts(){
		
		return dao.getAllProducts();
		
		
	}
	
	public List<Product> getAllProductsDesc(){
		return dao.getAllProductsDesc();
		
	}
	
	public List<Product> getAllProductsAsc(){
		
		return dao.getAllProductsAsc();
	}
    
	public List<Product> getAllProductsBetween(){
		
		return dao.getAllProductsBetween();
	}
	
	public List<Product> restrictionsEx(){
		
		return dao.restrictionsEx();
	}
}
