package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.CommentsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<CommentsEntity, Integer> {
}
