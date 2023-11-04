package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.PublicationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends MongoRepository<PublicationEntity, Integer> {
}
