package com.marcionascimento.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcionascimento.workshopmongo.domain.User;
import com.marcionascimento.workshopmongo.dto.UserDTO;
import com.marcionascimento.workshopmongo.repository.UserRepository;
import com.marcionascimento.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById2(String id){
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	
	
	
	/*
	public User update(String id){
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		update(newObj, id);
		return repo.save(newObj)
	}
	*/
	/*
	public User update(User obj, String id) {
		User newObj = repo.findById(id).orElse(null); 
		update(newObj, id);
		return repo.save(newObj);
	}
	*/
	

	
	/*
	 * public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	 */
	


	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
	
	

}
