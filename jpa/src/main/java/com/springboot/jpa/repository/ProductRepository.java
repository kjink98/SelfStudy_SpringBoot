package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
