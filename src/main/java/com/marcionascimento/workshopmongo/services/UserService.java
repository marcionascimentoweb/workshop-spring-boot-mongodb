package com.marcionascimento.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcionascimento.workshopmongo.domain.User;
import com.marcionascimento.workshopmongo.repository.UserRepository;
import com.marcionascimento.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id){
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}

}
