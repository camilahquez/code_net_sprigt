package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.DataUserEntity;
import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Service.DataUserService;
import com.example.code_net_mongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataUserController {
    private final DataUserService service;

    @Autowired
    public DataUserController(DataUserService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarDataUser", method = RequestMethod.GET)
    public ResponseEntity<?> consultarDataUser(){
        List<DataUserEntity> dataUserList = this.service.consultarDataUser();
        return  ResponseEntity.ok(dataUserList);
    }
    @PutMapping
    @RequestMapping(value = "createDataUser", method = RequestMethod.POST)
    public ResponseEntity<?> createDataUser(@RequestBody DataUserEntity data){
        DataUserEntity dataModificada = this.service.createDataUser(data);
        return  ResponseEntity.status(HttpStatus.CREATED).body(dataModificada);
    }
    @PutMapping
    @RequestMapping(value = "ModificarDataUser", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarDataUser(@RequestBody  DataUserEntity data){
        DataUserEntity datosModificados = this.service.ModificarDataUser(data);
        return  ResponseEntity.status(HttpStatus.CREATED).body(datosModificados);
    }
    @GetMapping
    @RequestMapping(value = "BuscarDataUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarDataUser(@PathVariable int id){
        DataUserEntity databuscar= this.service.BuscarDataUser(id);
        return  ResponseEntity.ok(databuscar);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarDataUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarDataUser(@PathVariable int id){
        this.service.EliminarDataUser(id);
        return  ResponseEntity.ok().build();
    }
}
