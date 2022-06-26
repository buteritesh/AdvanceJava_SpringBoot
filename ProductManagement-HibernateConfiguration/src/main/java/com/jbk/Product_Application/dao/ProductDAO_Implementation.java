package com.jbk.Product_Application.dao;



import java.io.Serializable;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Product_Application.entity.Product;

@Repository
public class ProductDAO_Implementation implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public Serializable addProduct(Product product) {

		Serializable id=null;
		try
		{
			Product p=null;
			
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Product.class);
			criteria.add(Restrictions.eq("product_name", product.getProduct_name()));
			p=(Product) criteria.uniqueResult();
			
			if(p==null)
			{
				id=sessionFactory.getCurrentSession().save(product);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public Product getProductById(Integer id) {

		
		Product product=null;
		
		try
		{
			
			product=sessionFactory.getCurrentSession().get(Product.class, id);
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> productList = null;
		
		try {

			productList=sessionFactory.getCurrentSession().createCriteria(Product.class).list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return productList;
		
	}

	@Override
	public boolean deleteProduct(Integer id) {
		Boolean b=false;
		try
		{
			Product p=null;
			
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Product.class);
			
			criteria.add(Restrictions.eq("product_id",id));
			
			p=(Product) criteria.uniqueResult();
			
			System.out.println(p);
			
			if(p!=null)
			{
				sessionFactory.getCurrentSession().delete(p);
				b=true;
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean updateProduct(Product product) {

//
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(product);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return true;
//		
//		Above aproach throws Duplicate entry 'Product' for Unique Key Constraint
		
		
		Boolean b=false;
		try
		{
			Product p=null;
			
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Product.class);
			
			criteria.add(Restrictions.eq("product_name",product.getProduct_name()));
			
			p=(Product) criteria.uniqueResult();
			
			System.out.println(p);
			
			p.setProduct_name(product.getProduct_name());
			p.setQuantity_per_unit(product.getQuantity_per_unit());
			p.setSupplier_id(product.getSupplier_id());
			p.setUnit_price(product.getUnit_price());
			
			if(p!=null)
			{
				sessionFactory.getCurrentSession().update(p);
				b=true;
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}
}
