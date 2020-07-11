package com.witoraugusto.worckshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witoraugusto.worckshopMongo.domain.Post;
import com.witoraugusto.worckshopMongo.repositories.PostRepository;
import com.witoraugusto.worckshopMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository userRepository;

	public Post findById(String id) {
		Optional<Post> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
