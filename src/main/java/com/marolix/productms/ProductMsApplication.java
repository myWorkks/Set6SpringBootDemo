package com.marolix.productms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marolix.productms.dto.ProductDTO;
import com.marolix.productms.entity.Product;
import com.marolix.productms.service.ProductService;

@SpringBootApplication
public class ProductMsApplication implements CommandLineRunner {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {

		SpringApplication.run(ProductMsApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// addProduct();
		// getProductById();
		// viewByBrand();
		// filterByprice();
		// filterByPriceAndName();
		// filterByRange();
		// sortByName();
		// deleteEntity();
		// deleMultipleEntities();
		updateQuantity();
	}

	public void filterByprice() {
		System.out.println("Enter the price");
		float f = sc.nextFloat();
		List<ProductDTO> dtos = productService.filterByPriceGreater(f);
		System.out.println("Products based on price greater  " + f);

		System.out.println("----------------------------------------------");
		System.out.println("name" + "\t" + "price");
		System.out.println("----------------------------------------------");
		for (ProductDTO productDTO : dtos) {
			System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());
		}
		System.out.println("----------------------------------------------");
	}

	public void viewByBrand() {

		System.out.println("enter the brand name to search");
		String s = sc.nextLine();
		// next()
//		List<ProductDTO> dtos = productService.findProductByBrandName(s);
		ProductDTO productDTO = productService.findProductByBrandName(s);
		System.out.println("Products based on brand  " + s);

		System.out.println("----------------------------------------------");
		System.out.println("name" + "\t" + "price");
		System.out.println("----------------------------------------------");
//		for (ProductDTO productDTO : dtos) {
//			System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());
//		}

		System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());

		System.out.println("----------------------------------------------");
	}

	public void addProduct() {
		System.out.println("creating the new prod info");
		ProductDTO dto = new ProductDTO();
//		dto.setProdId(1);
		System.out.println("enter product name");
		dto.setProdName(sc.nextLine());
		System.out.println("enter brand name");
		dto.setBrand(sc.next());
		System.out.println("enter price");
		dto.setPrice(sc.nextFloat());
		System.out.println("enter discount");
		dto.setDiscountPercent(sc.nextFloat());
		System.out.println("eneter quantity");
		dto.setQuantity(sc.nextInt());
		System.out.println("eneter desc");
		dto.setDesc(sc.next());
		productService.addProduct(dto);
	}

	public void getProductById() {
		Integer prodId = 1;
		ProductDTO dto = productService.findProductById(prodId);
		System.out.println(dto);
	}

	public void filterByPriceAndName() {

		System.out.println("Enter the price");
		float f = sc.nextFloat();
		System.out.println("enter product  name");
		String name = sc.next();
		List<ProductDTO> dtos = productService.filterByPriceAndName(f, name);

		System.out.println("price " + f);
		System.out.println("name " + name);
		System.out.println("Products based on price greater  " + f);

		System.out.println("----------------------------------------------");
		System.out.println("name" + "\t" + "price");
		System.out.println("----------------------------------------------");
		for (ProductDTO productDTO : dtos) {
			System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());
		}
		System.out.println("----------------------------------------------");
		sc.close();
	}

	public void filterByRange() {

		System.out.println("Enter min price");
		float f = sc.nextFloat();
		System.out.println("enter max price");
		float name = sc.nextFloat();
		List<ProductDTO> dtos = productService.filterBypriceRange(f, name);

		System.out.println("price " + f);
		System.out.println("name " + name);
		// System.out.println("Products based on price greater " + f);

		System.out.println("----------------------------------------------");
		System.out.println("name" + "\t" + "price");
		System.out.println("----------------------------------------------");
		for (ProductDTO productDTO : dtos) {
			System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());
		}
		System.out.println("----------------------------------------------");
		sc.close();
	}

	public void sortByName() {
		System.out.println("enter the sort ");
		ProductDTO productDTO = productService.sortByName(sc.nextLine());
		System.out.println("----------------------------------------------");
		System.out.println("name" + "\t" + "price");
		System.out.println("----------------------------------------------");
		System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());
		System.out.println("----------------------------------------------");
	}

	public void deleteEntity() {
		System.out.println("enter the id");
		productService.deleteEntity(sc.nextInt());
		System.out.println("entity deleted successfully");
		sc.close();
	}

	public void deleMultipleEntities() {
		System.out.println("enter the number of entities to be delted");
		int a = sc.nextInt();
		List<Integer> prodIds = new ArrayList<Integer>();
		for (int i = 0; i < a; i++) {
			System.out.println("enter id");
			prodIds.add(sc.nextInt());
		}
		productService.deleteMultipleEntities(prodIds);
		System.out.println("deleted entities");

	}

	private void updateQuantity() {
		System.out.println("enter product id");
		int prodId = sc.nextInt();
		System.out.println("enter qunatity");
		int quantity = sc.nextInt();
		String p = productService.updateProductQuantity(prodId, quantity);
		System.out.println(p);
	}
}
