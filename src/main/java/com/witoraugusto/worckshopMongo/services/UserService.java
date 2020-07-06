package com.witoraugusto.worckshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.witoraugusto.worckshopMongo.domain.User;
import com.witoraugusto.worckshopMongo.dto.UserDto;
import com.witoraugusto.worckshopMongo.repositories.UserRepository;
import com.witoraugusto.worckshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	// inserir dados
	public User insert(User obj) {
		return userRepository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);

	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return userRepository.save(newObj);
	}

	private void updateDate(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
