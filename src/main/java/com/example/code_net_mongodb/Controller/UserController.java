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

    //consultar todos los usuarios
    @GetMapping
    @RequestMapping(value = "consultarUser", method = RequestMethod.GET)
    public ResponseEntity<?> consultarUser(){
        List<UserEntity> userList = this.service.consultarUser();
        return  ResponseEntity.ok(userList);
    }
    @PostMapping
    @RequestMapping(value = "createUsuario", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody  UserEntity user){
        UserEntity userCreado= this.service.createUser(user);
        if (userCreado == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        return  ResponseEntity.status(HttpStatus.CREATED).body(userCreado);
    }
    @PutMapping
    @RequestMapping(value = "ModificarUsuario", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarUser(@RequestBody  UserEntity user){
        UserEntity userModificado = this.service.ModificarUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userModificado);
    }

    //buscar un usuario especifico por el id
    @GetMapping
    @RequestMapping(value = "BuscarUsuario/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarUser(@PathVariable int idUsuario){
        UserEntity userbuscado= this.service.BuscarUserById(idUsuario);
        return  ResponseEntity.ok(userbuscado);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarUsuario/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarUser(@PathVariable int idUsuario){
        this.service.EliminarUser(idUsuario);
        return  ResponseEntity.ok().build();
    }
}
