package com.chaves.workshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chaves.workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {	
	
}
