package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.DataUserEntity;
import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Repository.DataUserRepository;
import com.example.code_net_mongodb.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataUserService {

    private DataUserRepository Repository;
    @Autowired
    public DataUserService(DataUserRepository Repository) {
        this.Repository = Repository;
    }

    public List<DataUserEntity> consultarDataUser() {
        return (List<DataUserEntity>) this.Repository.findAll();
    }
    public DataUserEntity createDataUser(DataUserEntity data) {
        return Repository.save(data);
    }
    public DataUserEntity ModificarDataUser(DataUserEntity data) {

        return this.Repository.save(data);
    }
    public DataUserEntity BuscarDataUser(String email) {

        return this.Repository.findByEmail(email).get();
    }
    public void EliminarDataUser(String email) {
        this.Repository.deleteByEmail(email);
    }

}
