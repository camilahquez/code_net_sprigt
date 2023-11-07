package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.CommentsEntity;
import com.example.code_net_mongodb.Repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentsService {

    private CommentsRepository Repository;
    private SequenceService sequenceService;

    @Autowired
    public CommentsService(CommentsRepository repository, SequenceService sequenceService) {
        this.Repository = repository;
        this.sequenceService = sequenceService;
    }

    public List<CommentsEntity> consultarComments() {
        return (List<CommentsEntity>) this.Repository.findAll();
    }

    public CommentsEntity createComments(CommentsEntity Comments) {
        Comments.setId(sequenceService.getNextId("comments"));
        Comments.setDateCommets(LocalDateTime.now());
        return Repository.save(Comments);
    }

    public CommentsEntity ModificarComments(CommentsEntity Comments) {
        return this.Repository.save(Comments);
    }

    public CommentsEntity BuscarComments(int idPublicacion, int idUsuario) {
        return this.Repository.findByIdPublicacionAndIdUsuario(idPublicacion, idUsuario).get();
    }

    public void EliminarComments(int idPublicacion, int idUsuario) {
        this.Repository.deleteByIdPublicacionAndIdUsuario(idPublicacion, idUsuario);
    }

    public Page<CommentsEntity> CommentsByPublicationAndEmail(int idPublicacion, int pageNumber, int pageSize) {
        Pageable pegeable = PageRequest.of(pageNumber, pageSize);
        return this.Repository.findByIdPublicacion(idPublicacion, pegeable);
    }


}
