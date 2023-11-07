package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.LikesEntity;
import com.example.code_net_mongodb.Repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {
    private LikesRepository Repository;
    private SequenceService sequenceService;

    @Autowired
    public LikesService(LikesRepository Repository, SequenceService sequenceService) {
        this.Repository = Repository;
        this.sequenceService = sequenceService;
    }

    public List<LikesEntity> consultarLikes() {
        return (List<LikesEntity>) this.Repository.findAll();
    }

    public LikesEntity createLikes(LikesEntity Like) {
        Like.setId(sequenceService.getNextId("likes"));
        return Repository.save(Like);
    }

    public LikesEntity ModificarLikes(LikesEntity Like) {
        return this.Repository.save(Like);
    }

    public LikesEntity BuscarLikes(int idPublicacion, int idUsuario) {
        return this.Repository.findByIdPublicacionAndIdUsuario(idPublicacion, idUsuario);
    }

    public void EliminarLikes(int idPublicacion, int idUsuario) {
        this.Repository.deleteByIdPublicacionAndIdUsuario(idPublicacion, idUsuario);
    }

    public Page<LikesEntity> likesByIdPublication(int idPublicacion, int pageNumber, int pageSize) {
        Pageable pegeable = PageRequest.of(pageNumber, pageSize);
        return this.Repository.findByIdPublicacion(idPublicacion, pegeable);

    }
}
