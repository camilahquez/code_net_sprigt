package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.SequenceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends MongoRepository<SequenceEntity, String> {
    SequenceEntity findByCollectionName(String collectionName);
    boolean existsByCollectionName(String collectionName);

    void deleteByCollectionName(String collectionName);
}
