package com.witoraugusto.worckshopMongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.witoraugusto.worckshopMongo.domain.Post;
import com.witoraugusto.worckshopMongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService userService;

	@GetMapping(value = ("/{id}"))
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
