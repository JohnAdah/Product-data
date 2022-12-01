package com.learning.springjpa.product.data.Repository;

import com.learning.springjpa.product.data.Models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
        //Finding a row with a single query parameter
        List<Product> findByName(String name);

        //Querying the database table with multiple parameters
        List<Product> findByNameAndDesc(String name, String desc);

        //Query price with the greater than logical expression
        List<Product> findByPriceGreaterThan(double price);

        List<Product> findByDescContains(String name);

        //Using the between logical expression
        List<Product>  findByPriceBetween(double double1, double double2);

        //Using the LIKE expression to query the database table
        List<Product> findByNameLike(String name);

        List<Product> findByIdIn(List<Integer> id);

        // The message below enables
        List<Product> findByIdIn(List<Integer>ids, Pageable pageable);

}
