package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.AmigosEntity;
import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Repository.AmigosRepository;
import com.example.code_net_mongodb.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AmigosService {
    private AmigosRepository repository;
    private SequenceService sequenceService;

    @Autowired
    public AmigosService(AmigosRepository repository, SequenceService sequenceService) {
        this.repository = repository;
        this.sequenceService = sequenceService;
    }

    public List<AmigosEntity> consultarAmigos() {
        return (List<AmigosEntity>) this.repository.findAll();
    }
    public AmigosEntity createAmigos(AmigosEntity amigos) {
        amigos.setId(sequenceService.getNextId("amigos"));
        amigos.setDateAmistad(LocalDateTime.now());
        return repository.save(amigos);
    }
    public AmigosEntity ModificarAmigos(AmigosEntity amigos) {

        return this.repository.save(amigos);
    }
    public AmigosEntity BuscarAmigos(int idAmistad) {
        return this.repository.findById(idAmistad).get();
    }
    public void EliminarAmigos(int idAmistad) {
        this.repository.deleteById(idAmistad);
    }
    public List<AmigosEntity> BuscarAmigosByIdUsuario(int idUsuario){

        return this.repository.findByIdUsuario(idUsuario);
    }


}
