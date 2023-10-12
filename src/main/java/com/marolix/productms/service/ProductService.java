package com.marolix.productms.service;

import java.util.List;

import com.marolix.productms.dto.ProductDTO;

public interface ProductService {

	public String addProduct(ProductDTO productInfoByUser);

	ProductDTO findProductById(Integer id);

	List<ProductDTO> findProductByBrandName(String brand);

	List<ProductDTO> filterByPriceGreater(Float price);

	List<ProductDTO> filterByPriceAndName(Float price, String name);

}
