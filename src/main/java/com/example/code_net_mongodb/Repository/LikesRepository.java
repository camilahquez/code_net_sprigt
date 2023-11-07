package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.LikesEntity;
import com.example.code_net_mongodb.Entity.PublicationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LikesRepository extends MongoRepository<LikesEntity, Integer> {
    LikesEntity findByIdPublicacionAndIdUsuario(int idPublicacion, int idUsuario);

    // Solamente el like de un usuario ne una publicación
    Page<LikesEntity> findByIdPublicacion(int idPublicacion, Pageable pageable);
    void deleteByIdPublicacionAndIdUsuario(int idPublicacion, int idUsuario);
}
