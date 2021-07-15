package com.treinamento.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.course.entities.OrdemItem;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, Long> {

}
