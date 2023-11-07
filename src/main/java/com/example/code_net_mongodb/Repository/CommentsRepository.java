package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.CommentsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsRepository extends MongoRepository<CommentsEntity, Integer> {
    Page<CommentsEntity> findByIdPublicacion(int idPublicacion, Pageable pageable);
    Optional<CommentsEntity> findByIdPublicacionAndIdUsuario(int idPublicacion, int idUsuario);
    void deleteByIdPublicacionAndIdUsuario(int idPublicacion, int idUsuario);
}
