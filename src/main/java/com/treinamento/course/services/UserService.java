package com.treinamento.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.treinamento.course.entities.User;
import com.treinamento.course.repositories.UseRepository;
import com.treinamento.course.services.exceptions.DatabaseException;
import com.treinamento.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UseRepository useRepository;
	
	public List<User> findAll(){
		return useRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = useRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return useRepository.save(user);
	}
	public void delete(Long id) {
		try {
		useRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		User entity = useRepository.getOne(id);
		updateData(entity, obj);
		return useRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}
