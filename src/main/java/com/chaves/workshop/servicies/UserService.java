package com.chaves.workshop.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaves.workshop.domain.User;
import com.chaves.workshop.dto.UserDTO;
import com.chaves.workshop.repositories.UserRepository;
import com.chaves.workshop.servicies.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Object user = repository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		} 
		return (User) user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		repository.deleteById(id);
		if (id == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

}
