package com.marolix.productms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "product")
public class Product {

	@Column(name = "product_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pkgen")
//	@TableGenerator(
//			name = "pkgen",
//	table = "primary_key",
//	pkColumnName = "g_key",
//	valueColumnName = "g_value",
//	pkColumnValue = "prod_id",
//	allocationSize = -1)
	@SequenceGenerator(
			name = "pkgen",
	sequenceName  = "sequence_name",
	
	allocationSize = 1)
	private Integer prodId;

	@Column(name = "product_name", unique = false, nullable = true)
	private String prodName;

	@Column(name = "brand_name")
	private String brand;
	@Column(name = "discount_percent")
	private Float discountPercent;
	@Column(name = "product_price")
	private Float price;

	@Column(name = "product_quanity")
	private Integer quantity;

	@Column(name = "product_description")
	private String desc;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Product() {
		super();

	}

	public Product(Integer prodId, String prodName, String brand, Float discountPercent, Float price, Integer quantity,
			String desc) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.brand = brand;
		this.discountPercent = discountPercent;
		this.price = price;
		this.quantity = quantity;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", brand=" + brand + ", discountPercent="
				+ discountPercent + ", price=" + price + ", quantity=" + quantity + ", desc=" + desc + "]";
	}

}
