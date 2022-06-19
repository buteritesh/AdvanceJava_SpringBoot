package com.jbk.Product_Application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
	
	@Column(name="product_name",unique = true)
	@NotNull
	private String productName;
	
	@Column(name="supplier_id")
	@NotNull(message="supplierId field missing in body")
	@NotBlank(message="supplierId can not be blank")
	private Integer supplierId;
	
	@Column(name="quantity_per_unit")
	@NotNull(message="quantityPerUnit field missing in body")
	@NotBlank(message="quantityPerUnit can not be blank")
	private String quantityPerUnit;
	
	@Column(name="unit_price")
	@NotNull
	private Double unitPrice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, Integer supplierId, String quantityPerUnit,
			Double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice + "]";
	}
	
	
	
	
	
	

}
