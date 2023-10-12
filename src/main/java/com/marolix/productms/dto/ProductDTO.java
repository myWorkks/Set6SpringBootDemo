package com.marolix.productms.dto;

public class ProductDTO {

	private Integer prodId;

	private String prodName;

	private String brand;

	private Float discountPercent;

	private Float price;

	private Integer quantity;

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

	public ProductDTO() {
		super();
		
	}

	public ProductDTO(Integer prodId, String prodName, String brand, Float discountPercent, Float price, Integer quantity,
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
		return "ProductDTO [prodId=" + prodId + ", prodName=" + prodName + ", brand=" + brand + ", discountPercent="
				+ discountPercent + ", price=" + price + ", quantity=" + quantity + ", desc=" + desc + "]";
	}

}
