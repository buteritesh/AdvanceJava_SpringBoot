package com.jbk.Product_Application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Product_Application.exceptions.ProductAlreadyExistException;
import com.jbk.Product_Application.exceptions.ProductNotFoundException;
import com.jbk.Product_Application.entity.Product;
import com.jbk.Product_Application.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired(required = true)
	ProductService productService;

	@PostMapping("addproduct")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product) {
		Boolean b = productService.addProduct(product);
		if (b) {
			return new ResponseEntity<>("Product saved !!!", HttpStatus.OK);
		} else {
			throw new ProductAlreadyExistException("Product exist already");
		}
	}

	@GetMapping("getproductbyid")
	public ResponseEntity<Product> getProductById(@RequestParam Integer id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Product id : "+id+" does not exist");
		}

	}

	@GetMapping(value = "/getallproducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> products = productService.getAllProduct();
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("No Products to display !!!");
		}
	}
	@DeleteMapping(value = "/deleteproductbyid")
	public ResponseEntity<Object> deleteProductById(@RequestParam Integer id)
	{
		Boolean b=productService.deleteProduct(id);
		System.out.println(b);
		if (b) {
			return new ResponseEntity<>("Product deleted !!!", HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Product id : "+id+" does not Exist");
		}
		
	}
	
	@PutMapping(value="updateproduct")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product)
	{
		Boolean b=productService.updateProduct(product);
		
		if (b) {
			return new ResponseEntity<>("Product updated !!!", HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Product : "+product.getProduct_name()+" does not exist !!!");
		}
	}
	
	@GetMapping(value="generatereport")
	public ResponseEntity<String> generateReport(@RequestParam String format,HttpServletResponse response)
	{
		String msg=productService.generateReport(format,response);
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}

}
