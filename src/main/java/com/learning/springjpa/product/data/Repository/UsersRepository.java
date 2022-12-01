package com.learning.springjpa.product.data.Repository;

import com.learning.springjpa.product.data.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface UsersRepository extends JpaRepository<User, Id> {
}
