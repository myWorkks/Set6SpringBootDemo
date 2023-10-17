package com.marolix.productms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marolix.productms.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	// List<Product> findByBrand(String brand);
	Product findByBrand(String brand);

//select * from product where brand=brand;
//ResultSet
//while(rs.next){
//}
//	@Query(value = "select * from Product p where p.product_price>=:p", nativeQuery = true)
	// List<Product> findByPriceGreaterThan1(@Parame("p")Float price);// select *
	// from product where price>=price
	@Query(value = "select * from Product p where p.product_price>=?1", nativeQuery = true)
	List<Product> findByPriceGreaterThan1(Float price);// select * from product where price>=price

	List<Product> findByPriceGreaterThanAndProdNameLike(Float price, String name);

//@Query(value="select p from Product p where p.price>=?2 and p.price<=?1")
//	List<Product> findByPriceBetween1(Float price1, Float price2);
	@Query(value = "select p from Product p where p.price>=:min_price and p.price<=:max_price")
	List<Product> findByPriceBetween1(@Param("min_price") Float price1, @Param("max_price") Float price2);

	Product findAllOrderByProdName(String name);
//Jpql

	@Query(value = "update Product p set p.quantity=?1 where p.prodId=?2", nativeQuery = false)
	@Modifying
	void updateProduct(Integer quantity, Integer prodId);

}
