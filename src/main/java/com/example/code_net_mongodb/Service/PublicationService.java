package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublicationService {
    private PublicationRepository repository;
    private SequenceService sequenceService;

    @Autowired
    public PublicationService(PublicationRepository repository, SequenceService sequenceService) {
        this.repository = repository;
        this.sequenceService = sequenceService;
    }

    public List<PublicationEntity> consultarPublication() {
        return (List<PublicationEntity>) this.repository.findAll();
    }
    public PublicationEntity createPublication(PublicationEntity Publication) {
        Publication.setId(sequenceService.getNextId("publication"));
        Publication.setDatePublication(LocalDateTime.now());
        return repository.save(Publication);
    }
    public PublicationEntity ModificarPublication(PublicationEntity Publication) {

        return this.repository.save(Publication);
    }
    public PublicationEntity BuscarPublication(int idPublicacion) {
        return this.repository.findById(idPublicacion).get();
    }
    public void EliminarPublication(int idPublicacion) {
        this.repository.deleteById(idPublicacion);
    }
    public Page<PublicationEntity> publicationByIdUser(int idUsuario, int pageNumber, int pageSize) {
        Pageable pegeable = PageRequest.of(pageNumber, pageSize);
        return  this.repository.findByIdUsuario(idUsuario, pegeable);
    }

}
