package com.jbk.Product_Application.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jbk.Product_Application.dao.ProductDAO;
import com.jbk.Product_Application.entity.Product;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

	@Override
	public String generateReport(String format,HttpServletResponse response) {
		
		List<Product> productsList=productDAO.getAllProduct();
		
		String destination="C:\\Users\\sanke\\Desktop\\JasperExportedfiles";
		
		try {
			File file=ResourceUtils.getFile("classpath:ProductReport.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(productsList);
			
			JasperPrint  jasperPrint=JasperFillManager.fillReport(jasperReport, null,dataSource);
			
			System.out.println(format);
			if(format.equals("pdf"))
			{
				JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
				JasperExportManager.exportReportToPdfFile(jasperPrint, destination+"\\productInfo.pdf");
				destination="File generated at "+ destination;
				return destination;
			}
			else
			{
				return "Invalid format";
			}
			
		}
		catch(FileNotFoundException f)
		{
			f.getMessage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return destination;
	}
	
	

	

}
