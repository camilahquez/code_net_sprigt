package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Service.PublicationService;
import com.example.code_net_mongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PublicationController {
    private final PublicationService service;

    @Autowired
    public PublicationController(PublicationService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarPublication", method = RequestMethod.GET)
    public ResponseEntity<?> consultarPublication(){
        List<PublicationEntity> publicationList = this.service.consultarPublication();
        return  ResponseEntity.ok(publicationList);
    }
    @PutMapping
    @RequestMapping(value = "createPublication", method = RequestMethod.POST)
    public ResponseEntity<?> createPublication(@RequestBody  PublicationEntity publication){
        PublicationEntity publicationCreado= this.service.createPublication(publication);
        return  ResponseEntity.status(HttpStatus.CREATED).body(publicationCreado);
    }
    @PutMapping
    @RequestMapping(value = "ModificarPublication", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarPublication(@RequestBody  PublicationEntity publication){
        PublicationEntity  publicationModificado = this.service.ModificarPublication(publication);
        return  ResponseEntity.status(HttpStatus.CREATED).body(publicationModificado);
    }

    @GetMapping
    @RequestMapping(value = "BuscarPublication/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPublication(@PathVariable int id){
        PublicationEntity publicationbuscada= this.service.BuscarPublication(id);
        return  ResponseEntity.ok(publicationbuscada);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarPublication/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPublication(@PathVariable int id){
        this.service.EliminarPublication(id);
        return  ResponseEntity.ok().build();
    }
}
