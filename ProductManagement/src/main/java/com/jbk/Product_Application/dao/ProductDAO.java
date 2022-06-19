package com.jbk.Product_Application.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.Product_Application.entity.Product;

public interface ProductDAO {

	Boolean addProduct(Product product);

	Product getProductById(Integer id);

	public List<Product> getAllProduct();

	public boolean deleteProduct(Integer id);

	public boolean updateProduct(Product product);

}
