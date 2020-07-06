package com.witoraugusto.worckshopMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witoraugusto.worckshopMongo.domain.User;
import com.witoraugusto.worckshopMongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired 
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
