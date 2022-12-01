package com.learning.springjpa.product.data;

import com.learning.springjpa.product.data.Models.Product;
import com.learning.springjpa.product.data.Repository.ProductRepository;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class ProductDataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = new Product();
		product.setId(7);
		product.setName("LG");
		product.setDesc("Medium size, Home theatre, Black Color, 2021 Series");
		product.setPrice(26000.00);

		productRepository.save(product);
	}

	@Test
	public void testRead(){
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("Nexus TV",product.getName());
	}

	@Test
	public void testUpdate(){
		Product product = productRepository.findById(1).get();
		System.out.println(product);
		product.setPrice(3000.00);
		productRepository.save(product);
		System.out.println("New value of product price after updating");
		System.out.println(product);
	}

	@Test
	public void testDelete(){
		Product product = new Product();
		if(productRepository.existsById(1)){
			System.out.println("Deleting product with id = " + product.getId());
			productRepository.deleteById(1);
		}
	}

	//Test to show the number of records in the database
	@Test
	public void testCount(){
		System.out.println("Total number of records is ======== " + productRepository.count());
	}

	@Test
	public void findByNameTest(){
		List<Product> products = productRepository.findByName("IWatch");
		products.forEach(p-> System.out.println(p.toString()));
	}

	@Test
	public void findByNameAndDescTest(){
		List<Product> products = productRepository.findByNameAndDesc("clipper","From Toshiba");
		products.forEach(p-> System.out.println(p.toString()));
	}

	@Test
	public void findByPriceGreaterThanTest(){
		List<Product> products = productRepository.findByPriceGreaterThan(2000);
		products.forEach(p-> System.out.println(p.toString()));
	}

	@Test
	public void findByDescContainsTest(){
		List<Product> product = productRepository.findByDescContains("Hisense");
		product.forEach(p -> System.out.println(
				p.toString()
		));
	}

	@Test
	public void findByPriceBetweenTest(){
		List<Product> products = productRepository.findByPriceBetween(2400,5500);
		products.forEach(p->
				System.out.println(p.getName() + "---" + p.getPrice()));
	}

	@Test
	public void findByNameLikeTest(){
		List<Product> products = productRepository.findByNameLike("%IW%");
		products.forEach(p ->
				System.out.println(p.toString()));
	}

	@Test
	public void findByIdInTest(){
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1,3,5));
		products.forEach(p ->
				System.out.println(p.toString()));
	}
	int count= 0;
	@Test
	public void testFindAllPageable(){

		//First create a pageable object to be passed into the findAll method with page set properties
		Pageable pageable = PageRequest.of(count, 2, Sort.by("name").ascending());
		Page<Product> result = productRepository.findAll(pageable);
		result.forEach(p -> System.out.println(p.toString()));
		count++;
	}

	// Pageable uses the inbuilt findAll method not explicitly defined in the productRepository to
	// perform Query functions for Sorting and Pagination as shown in the method above.
	@Test
	public void findAllBySortingTest(){
		List<Product> products = (List<Product>) productRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
		products.forEach(p -> System.out.println(p.getName()));
	}

	//To Sort by Multiple properties, we pass in the different parameters as shown in the example below
	@Test
	public void findAllByMultipleSortedPropertiesTest() {
		List<Product> products = (List<Product>) productRepository.findAll(Sort.by(Sort.Direction.DESC, "name", "price"));
		products.forEach(p -> System.out.println(p.getName() +" - "+ p.getPrice()));
	}

	//Below code shows a list of sorted products by orders, this is achieved by individually
	@Test
	public void sortByDifferentOrderWithProperties(){
		List<Product> products = (List<Product>) productRepository.findAll(Sort.by
				(new Sort.Order(Sort.Direction.DESC, "name"), new Sort.Order(Sort.Direction.ASC,"Price")));
		products.forEach(p -> System.out.println(p.getName() +" - "+ p.getPrice()));
	}

	//To use paging and Sorting at the same time in a single function call
	@Test
	public void pagingAndSortingFindAll(){
		Pageable pageable = PageRequest.of(0,2, Sort.Direction.ASC,"name");
		Page<Product> product =  productRepository.findAll(pageable);
		product.forEach(p-> System.out.println(p.toString()));
	}

	//To Use a pagination with selected list of Ids
	@Test
	public void viewByIdsAndPaging(){
		Pageable pageable = PageRequest.of(2,2);
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1,2,3,4,5,6),pageable);
		products.forEach(p -> System.out.println(p.toString()));
	}



}
