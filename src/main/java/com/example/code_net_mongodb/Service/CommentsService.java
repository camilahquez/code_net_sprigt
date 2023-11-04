package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.CommentsEntity;
import com.example.code_net_mongodb.Repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private CommentsRepository Repository;

    @Autowired
    public CommentsService(CommentsRepository Repository) {
        this.Repository = Repository;
    }

    public List<CommentsEntity> consultarComments() {
        return (List<CommentsEntity>) this.Repository.findAll();
    }
    public CommentsEntity createComments(CommentsEntity Comments) {
        return Repository.save(Comments);
    }
    public CommentsEntity ModificarComments(CommentsEntity Comments) {

        return this.Repository.save(Comments);
    }
    public CommentsEntity BuscarComments(int id) {

        return this.Repository.findById(id).get();
    }
    public void EliminarComments(int id) {
        this.Repository.deleteById(id);







    }



}
