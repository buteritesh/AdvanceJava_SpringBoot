package com.jbk.Product_Application.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Product_Application.exceptions.ProductAlreadyExistException;
import com.jbk.Product_Application.dao.ProductDAO;
import com.jbk.Product_Application.entity.Product;

@Service
public class ProductServiceImplementaton implements ProductService{
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public Boolean addProduct(Product product){
		
		return productDAO.addProduct(product);
	}

	@Override
	public Product getProductById(Integer id) {
		
		
		return productDAO.getProductById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Override
	public boolean deleteProduct(Integer id) {
		
		return productDAO.deleteProduct(id);
	}

	@Override
	public boolean updateProduct(Product product) {
		
		return productDAO.updateProduct(product);
	}

	

}
