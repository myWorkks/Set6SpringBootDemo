package com.marolix.productms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marolix.productms.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByBrand(String brand);

//select * from product where brand=brand;
//ResultSet
//while(rs.next){
//}
	List<Product> findByPriceGreaterThan(Float price);// select * from product where price>=price

	List<Product> findByPriceGreaterThanAndProdNameLike(Float price, String name);

}
