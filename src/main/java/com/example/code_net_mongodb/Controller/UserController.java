package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarUser", method = RequestMethod.GET)
    public ResponseEntity<?> consultarUser(){
        List<UserEntity> userList = this.service.consultarUser();
        return  ResponseEntity.ok(userList);
    }
    @PutMapping
    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody  UserEntity user){
        UserEntity userCreado= this.service.createUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userCreado);
    }
    @PutMapping
    @RequestMapping(value = "ModificarUser", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarUser(@RequestBody  UserEntity user){
        UserEntity userModificado = this.service.ModificarUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userModificado);
    }

    @GetMapping
    @RequestMapping(value = "BuscarUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarUser(@PathVariable int id){
        UserEntity userbuscado= this.service.BuscarUser(id);
        return  ResponseEntity.ok(userbuscado);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarUser(@PathVariable int id){
        this.service.EliminarUser(id);
        return  ResponseEntity.ok().build();
    }
}
