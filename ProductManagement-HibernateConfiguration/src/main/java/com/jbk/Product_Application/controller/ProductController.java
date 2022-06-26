package com.jbk.Product_Application.controller;

import org.springframework.http.HttpHeaders;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jbk.Product_Application.exceptions.ProductAlreadyExistException;
import com.jbk.Product_Application.exceptions.ProductNotFoundException;
import com.jbk.Product_Application.entity.Product;
import com.jbk.Product_Application.service.ProductService;

@RestController
@RequestMapping("productmanagement")
public class ProductController {

	@Autowired(required = true)
	ProductService productService;

	@PostMapping(value="addproduct",headers = "Accept=application/json")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product, UriComponentsBuilder builder) {
		
		Serializable b = productService.addProduct(product);
		HttpHeaders header=new HttpHeaders();
		header.setLocation(builder.path("/product/{product_id}").buildAndExpand(product.getProduct_id()).toUri());
		if (b!=null) {
			return new ResponseEntity<>("Product added !!!",header, HttpStatus.CREATED);
			
		} else {
			throw new ProductAlreadyExistException("Product exist already");
		}
	}

	@GetMapping(value="getproductbyid",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@RequestParam("product_id") Integer product_id) {
		Product product = productService.getProductById(product_id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		} else {
			throw new ProductNotFoundException("Product id : "+product_id+" does not exist");
		}

	}

	@GetMapping(value = "/getallproducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> products = productService.getAllProduct();
		if (!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
		} else {
			throw new ProductNotFoundException("No Products to display !!!");
		}
	}
	@DeleteMapping(value = "/deleteproductbyid")
	public ResponseEntity<Object> deleteProductById(@RequestParam("product_id") Integer product_id)
	{
		System.out.println(product_id);
		Boolean b=productService.deleteProduct(product_id);
		System.out.println(b);
		if (b) {
			return new ResponseEntity<>("Product deleted !!!", HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Product id : "+product_id+" does not Exist");
		}
		
	}
	
	@PutMapping(value="/updateproduct",headers="Accept=application/json")
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
