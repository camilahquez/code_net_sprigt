package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.CommentsEntity;
import com.example.code_net_mongodb.Entity.LikesEntity;
import com.example.code_net_mongodb.Repository.CommentsRepository;
import com.example.code_net_mongodb.Repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {
    private LikesRepository Repository;

    @Autowired
    public LikesService(LikesRepository Repository) {
        this.Repository = Repository;
    }

    public List<LikesEntity> consultarLikes() {
        return (List<LikesEntity>) this.Repository.findAll();
    }
    public LikesEntity createLikes(LikesEntity Like) {
        return Repository.save(Like);
    }
    public LikesEntity ModificarLikes(LikesEntity Like) {

        return this.Repository.save(Like);
    }
    public LikesEntity BuscarLikes(int id) {

        return this.Repository.findById(id).get();
    }
    public void EliminarLikes(int id) {
        this.Repository.deleteById(id);
    }
}
