package com.learning.springjpa.product.data.Repository;

import com.learning.springjpa.product.data.Models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
