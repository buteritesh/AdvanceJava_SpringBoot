package com.jbk.Product_Application.service;



import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jbk.Product_Application.entity.Product;


public interface ProductService {
	
	public Serializable addProduct(Product product);
	
	public Product getProductById(Integer id);
	
	public List<Product> getAllProduct();
	
	public boolean deleteProduct(Integer id);
	
	public boolean updateProduct(Product product);
	
	public String generateReport(String format , HttpServletResponse response);
	

}