package com.marolix.productms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.productms.dto.ProductDTO;
import com.marolix.productms.entity.Product;
import com.marolix.productms.repository.ProductRepository;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public String addProduct(ProductDTO productInfoByUser) {
		Product prod = new Product();
		Integer i = productInfoByUser.getProdId();
//		prod.setProdId(i);
		prod.setDesc(productInfoByUser.getDesc());
		prod.setPrice(productInfoByUser.getPrice());
		prod.setDiscountPercent(productInfoByUser.getDiscountPercent());
		prod.setQuantity(productInfoByUser.getQuantity());
		prod.setProdName(productInfoByUser.getProdName());
		prod.setBrand(productInfoByUser.getBrand());
		productRepository.save(prod);
		return "product added Sccessfully";
	}

	@Override
	public ProductDTO findProductById(Integer id) {
		Optional<Product> opt = productRepository.findById(id);
		Product p = opt.orElseThrow(() -> new RuntimeException("No product found with id " + id));

		System.out.println("product entity " + p);
		ProductDTO dto = new ProductDTO();
		dto.setProdId(p.getProdId());
		dto.setProdName(p.getProdName());
		dto.setQuantity(p.getQuantity());
		dto.setBrand(p.getBrand());
		dto.setPrice(p.getPrice());
		dto.setDesc(p.getDesc());
		return dto;
	}

	@Override
	public List<ProductDTO> findProductByBrandName(String brand) {
		List<Product> products = productRepository.findByBrand(brand);
		List<ProductDTO> dto = products.stream().map((Product prod) -> {
			ProductDTO pdto = new ProductDTO();
			pdto.setBrand(prod.getBrand());
			pdto.setProdName(prod.getProdName());
			pdto.setPrice(prod.getPrice());
			return pdto;
		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public List<ProductDTO> filterByPriceGreater(Float price) {
		List<Product> products = productRepository.findByPriceGreaterThan(price);

		List<ProductDTO> dto = products.stream().map((Product prod) -> {
			ProductDTO pdto = new ProductDTO();
			pdto.setBrand(prod.getBrand());
			pdto.setProdName(prod.getProdName());
			pdto.setPrice(prod.getPrice());
			return pdto;
		}).collect(Collectors.toList());
		return dto;

	}

	@Override
	public List<ProductDTO> filterByPriceAndName(Float price, String name) {
		List<Product> products = productRepository.findByPriceGreaterThanAndProdNameLike(price, name);
		List<ProductDTO> dto = products.stream().map((Product prod) -> {
			ProductDTO pdto = new ProductDTO();
			pdto.setBrand(prod.getBrand());
			pdto.setProdName(prod.getProdName());
			pdto.setPrice(prod.getPrice());
			return pdto;
		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public List<ProductDTO> filterBypriceRange(Float start, Float end) {
		List<Product> products = productRepository.findByPriceBetween(start, end);
		List<ProductDTO> dto = products.stream().map((Product prod) -> {
			ProductDTO pdto = new ProductDTO();
			pdto.setBrand(prod.getBrand());
			pdto.setProdName(prod.getProdName());
			pdto.setPrice(prod.getPrice());
			return pdto;
		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public ProductDTO sortByName(String name) {
		Product prod = productRepository.findAllOrderByProdName(name);
		ProductDTO pdto = new ProductDTO();
		pdto.setBrand(prod.getBrand());
		pdto.setProdName(prod.getProdName());
		pdto.setPrice(prod.getPrice());
		return pdto;
	}

	@Override
	public void deleteEntity(Integer id) {
Optional<Product> opt=	productRepository.findById(id);
//if(opt.isPresent())
//	productRepository.deleteById(id);
Product prod=opt.orElse(null);
if(prod!=null)
	productRepository.delete(prod);
		
	}

	@Override
	public void deleteMultipleEntities(List<Integer> ids) {
Iterable<Product> products=	productRepository.findAllById(ids);
for(Product prod:products) {
	if(prod!=null) {
		productRepository.delete(prod);
	}
}
		
	}

}
