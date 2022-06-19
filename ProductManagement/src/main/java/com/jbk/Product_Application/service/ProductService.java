package com.jbk.Product_Application.service;



import java.util.List;

import com.jbk.Product_Application.entity.Product;


public interface ProductService {
	
	public Boolean addProduct(Product product);
	
	public Product getProductById(Integer id);
	
	public List<Product> getAllProduct();
	
	public boolean deleteProduct(Integer id);
	
	public boolean updateProduct(Product product);
	

}
