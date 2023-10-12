package com.marolix.productms;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marolix.productms.dto.ProductDTO;
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
//		viewByBrand();
		// filterByprice();
		filterByPriceAndName();
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
		List<ProductDTO> dtos = productService.findProductByBrandName(s);
		System.out.println("Products based on brand  " + s);

		System.out.println("----------------------------------------------");
		System.out.println("name" + "\t" + "price");
		System.out.println("----------------------------------------------");
		for (ProductDTO productDTO : dtos) {
			System.out.println(productDTO.getProdName() + "\t" + productDTO.getPrice());
		}
		System.out.println("----------------------------------------------");
	}

	public void addProduct() {
		System.out.println("creating the new prod info");
		ProductDTO dto = new ProductDTO();
//		dto.setProdId(1);
		dto.setProdName("Samsung Galaxy s23");
		dto.setBrand("Samsung");
		dto.setPrice(120000.00f);
		dto.setDiscountPercent(10.00f);
		dto.setQuantity(25);
		dto.setDesc("All Samsung Galaxy phones and other devices, including the company's Chromebook ");
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
}
