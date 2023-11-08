package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository Repository;
    private SequenceService sequenceService;

    @Autowired
    public UserService(UserRepository repository, SequenceService sequenceService) {
        this.Repository = repository;
        this.sequenceService = sequenceService;
    }

    public List<UserEntity> consultarUser() {
        return (List<UserEntity>) this.Repository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        user.setId(sequenceService.getNextId("user"));
        if (!Repository.existsByEmail(user.getEmail())) {
            user.setFechaCreate(LocalDateTime.now());
            return Repository.save(user);
        }
        return null;
    }

    public UserEntity ModificarUser(UserEntity user) {

        return this.Repository.save(user);
    }

    public UserEntity BuscarUserById(int idUsuario) {
        return this.Repository.findById(idUsuario).get();
    }

    public void EliminarUser(int idUsuario) {
        this.Repository.deleteById(idUsuario);
    }

    public Optional<UserEntity> BuscarUserByEmail(String email) {
        return this.Repository.findByEmail(email);
    }


}
