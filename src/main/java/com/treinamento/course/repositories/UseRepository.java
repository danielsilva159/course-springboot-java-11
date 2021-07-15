package com.treinamento.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.course.entities.User;

public interface UseRepository extends JpaRepository<User, Long> {

}
