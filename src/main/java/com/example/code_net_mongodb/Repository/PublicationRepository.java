package com.example.code_net_mongodb.Repository;

import com.example.code_net_mongodb.Entity.PublicationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends MongoRepository<PublicationEntity, Integer> {
    Page<PublicationEntity> findByIdUsuario(int idUsuario, Pageable pageable);
    List<PublicationEntity> findByTyPublication(String typePublication);
}
