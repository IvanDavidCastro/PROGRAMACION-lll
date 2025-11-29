package com.tecnar.repository;

import com.tecnar.model.ClienteDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryMongo extends MongoRepository<ClienteDoc, String> {}
