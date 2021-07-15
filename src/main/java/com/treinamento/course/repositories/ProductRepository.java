package com.treinamento.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
