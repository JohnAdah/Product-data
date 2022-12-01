package com.learning.springjpa.product.data;


import com.learning.springjpa.product.data.Models.Customer;
import com.learning.springjpa.product.data.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextLoad(){

    }

    @Test
    public void createCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Anyebe");
        customer.setSex("male");
        customerRepository.save(customer);
        System.out.println(customer.getId() + " saved into the database");
    }

    @Test
    public void readCustomer(){
        Customer customer = customerRepository.findById("CS181022014632").get();
        assertNotNull(customer);
        assertEquals("Matthew",customer.getFirstName());
    }

    @Test
    public void updateCustomer(){
        Customer customer = customerRepository.findById("CS181022014632").get();
        customer.setLastName("Owoicho");
        customerRepository.save(customer);
        assertEquals("Owoicho", customer.getLastName());
        System.out.println("Customer with id: "+ customer.getId() + " successfully updated");
    }

    @Test
    public void testCount(){
        System.out.println("Total records in the database is: " + customerRepository.count());
    }

    @Test
    public void deleteCustomer(){
        if(customerRepository.existsById("")){
            customerRepository.deleteById("");
        }

    }
}
