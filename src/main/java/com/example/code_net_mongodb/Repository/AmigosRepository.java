package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.AmigosEntity;
import com.example.code_net_mongodb.Entity.LikesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmigosRepository extends MongoRepository<AmigosEntity, Integer> {



}
