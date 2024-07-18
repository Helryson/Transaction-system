package com.transacao.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.transacao.teste.domain.entities.User;
import com.transacao.teste.repository.UserRepository;
import com.transacao.teste.service.exception.ResourceNotFoundException;

@Service
public class ValidationService {
	
	private final UserRepository userRepo;
	
	public ValidationService(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	
	public List<User> findAll(){
		List<User> list = userRepo.findAll();
		return list;
	}

	public User findById(Long id) {
		Optional<User> obj = userRepo.findById(id);
		if(!obj.isPresent()) {
			throw new ResourceNotFoundException("Usuário não encontrado");
		}
		return obj.get();
	}
	
}
