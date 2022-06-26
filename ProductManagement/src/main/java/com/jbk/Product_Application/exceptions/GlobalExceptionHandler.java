package com.jbk.Product_Application.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(ProductAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> alreadyExist(ProductAlreadyExistException p)
	{
		ErrorDetails errorDetails=new ErrorDetails(p.getMessage(), "you are trying to insert the Product which already Present in Database", new Date());
		return new ResponseEntity<>(errorDetails,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> productNotFound(ProductNotFoundException p)
	{
		ErrorDetails errorDetails=new ErrorDetails(p.getMessage(), 
				"The product you are trying to access does not exist anymore .", new Date());
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> validationExceptionHandler(MethodArgumentNotValidException notValidException)
	{
		
		ErrorDetails errorDetails=new ErrorDetails(notValidException.getBindingResult().getFieldError().getDefaultMessage(),
				notValidException.getMessage(), new Date());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}

}
