package com.witoraugusto.worckshopMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.witoraugusto.worckshopMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
