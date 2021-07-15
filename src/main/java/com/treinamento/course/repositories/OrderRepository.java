package com.treinamento.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
