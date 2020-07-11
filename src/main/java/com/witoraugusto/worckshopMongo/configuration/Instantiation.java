package com.witoraugusto.worckshopMongo.configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.witoraugusto.worckshopMongo.domain.Post;
import com.witoraugusto.worckshopMongo.domain.User;
import com.witoraugusto.worckshopMongo.dto.AuthorDto;
import com.witoraugusto.worckshopMongo.dto.CommentDto;
import com.witoraugusto.worckshopMongo.repositories.PostRepository;
import com.witoraugusto.worckshopMongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();// apagando todos primeiro
		postRepository.deleteAll();

		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!",
				new AuthorDto(u1));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDto(u1));

		CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(u2));
		CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(u3));
		CommentDto c3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(u2));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(post1, post2));

		u1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(u1);
	}
}
