package com.marolix.productms.service;

import java.util.List;

import com.marolix.productms.dto.ProductDTO;
import com.marolix.productms.entity.Product;

public interface ProductService {

	public String addProduct(ProductDTO productInfoByUser);

	ProductDTO findProductById(Integer id);

	// List<ProductDTO> findProductByBrandName(String brand);
	ProductDTO findProductByBrandName(String brand);

	List<ProductDTO> filterByPriceGreater(Float price);

	List<ProductDTO> filterByPriceAndName(Float price, String name);

	List<ProductDTO> filterBypriceRange(Float start, Float end);

	ProductDTO sortByName(String name);

	void deleteEntity(Integer id);

	void deleteMultipleEntities(List<Integer> ids);

	String updateProductQuantity(Integer prodId, Integer quantity);
}
