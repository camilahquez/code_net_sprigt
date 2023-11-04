package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.DataUserEntity;
import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Repository.DataUserRepository;
import com.example.code_net_mongodb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository Repository;
    @Autowired
    public UserService(UserRepository Repository) {
        this.Repository = Repository;
    }

    public List<UserEntity> consultarUser() {
        return (List<UserEntity>) this.Repository.findAll();
    }
    public UserEntity createUser(UserEntity user) {
        return Repository.save(user);
    }
    public UserEntity ModificarUser(UserEntity user) {

        return this.Repository.save(user);
    }
    public UserEntity BuscarUser(int id) {

        return this.Repository.findById(id).get();
    }
    public void EliminarUser(int id) {
        this.Repository.deleteById(id);
    }


}
