package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.LikesEntity;
import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Repository.LikesRepository;
import com.example.code_net_mongodb.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
    private PublicationRepository Repository;
    @Autowired
    public PublicationService(PublicationRepository Repository) {
        this.Repository = Repository;
    }

    public List<PublicationEntity> consultarPublication() {
        return (List<PublicationEntity>) this.Repository.findAll();
    }
    public PublicationEntity createPublication(PublicationEntity Publication) {
        return Repository.save(Publication);
    }
    public PublicationEntity ModificarPublication(PublicationEntity Publication) {

        return this.Repository.save(Publication);
    }
    public PublicationEntity BuscarPublication(int id) {

        return this.Repository.findById(id).get();
    }
    public void EliminarPublication(int id) {
        this.Repository.deleteById(id);
    }

}
