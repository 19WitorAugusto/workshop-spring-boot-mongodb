package com.witoraugusto.worckshopMongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.witoraugusto.worckshopMongo.domain.Post;
import com.witoraugusto.worckshopMongo.resources.util.URL;
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
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
		text = URL.decodeParam(text); //decodifica texto
		List<Post> list = userService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	

}
