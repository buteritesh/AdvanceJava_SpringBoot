package com.jbk.Product_Application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer product_id;
	
	@Column(unique = true,nullable=false)
	@NotNull
	private String product_name;
	
	@NotNull(message="supplierId field missing in body")
	@NotBlank(message="supplierId can not be blank")
	private String supplier_id;
	
	
	@NotNull(message="quantityPerUnit field missing in body")
	@NotBlank(message="quantityPerUnit can not be blank")
	private String quantity_per_unit;
	
	@NotNull(message="unit_price can not be null")
	private Double unit_price;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer product_id, @NotNull String product_name,
			@NotNull(message = "supplierId field missing in body") @NotBlank(message = "supplierId can not be blank") String supplier_id,
			@NotNull(message = "quantityPerUnit field missing in body") @NotBlank(message = "quantityPerUnit can not be blank") String quantity_per_unit,
			@NotNull Double unit_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.supplier_id = supplier_id;
		this.quantity_per_unit = quantity_per_unit;
		this.unit_price = unit_price;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getQuantity_per_unit() {
		return quantity_per_unit;
	}

	public void setQuantity_per_unit(String quantity_per_unit) {
		this.quantity_per_unit = quantity_per_unit;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", supplier_id=" + supplier_id
				+ ", quantity_per_unit=" + quantity_per_unit + ", unit_price=" + unit_price + "]";
	}
	

	
	
	
	
	

}
