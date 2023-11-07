package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.DataUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataUserRepository extends MongoRepository<DataUserEntity, String> {

    boolean existsByEmail(String email);
    Optional<DataUserEntity> findByEmail(String email);

    void deleteByEmail(String email);

}
