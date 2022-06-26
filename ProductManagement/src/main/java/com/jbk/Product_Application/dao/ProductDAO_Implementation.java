package com.jbk.Product_Application.dao;



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
	public Boolean addProduct(Product product) throws ConstraintViolationException {


		Boolean b=false;
		try
		{
			
			session = sessionFactory.openSession();
			Product p=null;
			
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", product.getProduct_name()));
			p=(Product) criteria.uniqueResult();
			Transaction t = session.beginTransaction();
			
			if(p==null)
			{
				session.save(product);
				t.commit();
				b=true;
			}
			
		}
		catch(ConstraintViolationException e)
		{
			throw e;
		}
		
		return b;
	}

	@Override
	public Product getProductById(Integer id) {

		
		Product product=null;
		
		try
		{
			session=sessionFactory.openSession();
			product=session.get(Product.class, id);
					
		}
		catch (Exception e) {
			
		}
		finally
		{
			session.close();
		}
		
		
		return product;
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> productList = null;
		
		try {

			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Product.class);
			productList=criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return productList;
		
	}

	@Override
	public boolean deleteProduct(Integer id) {
		
		Boolean b=false;
		try
		{
			
			session = sessionFactory.openSession();
			Product p=null;
			
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productId",id));
			
			p=(Product) criteria.uniqueResult();
			Transaction t = session.beginTransaction();
			
			if(p!=null)
			{
				session.delete(p);
				t.commit();
				b=true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return b;
	}

	@Override
	public boolean updateProduct(Product product) {

		Boolean b=false;
		try
		{
			
			session = sessionFactory.openSession();
			Product p=null;
			
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", product.getProduct_name()));
			p=(Product) criteria.uniqueResult();
			
			p.setProduct_name(product.getProduct_name());
			p.setQuantity_per_unit(product.getQuantity_per_unit());
			p.setSupplier_id(product.getSupplier_id());
			p.setUnit_price(product.getUnit_price());
			Transaction t = session.beginTransaction();
			if(p!=null)
			{
				session.update(p);
				t.commit();
				b=true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return b;
	}
}
