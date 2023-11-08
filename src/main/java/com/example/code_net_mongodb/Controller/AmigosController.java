package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.AmigosEntity;
import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Service.AmigosService;
import com.example.code_net_mongodb.Service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AmigosController {
    private final AmigosService service;

    @Autowired
    public AmigosController(AmigosService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarAmigos", method = RequestMethod.GET)
    public ResponseEntity<?> consultarAmigos(){
        List<AmigosEntity> amigosList = this.service.consultarAmigos();
        return  ResponseEntity.ok(amigosList);
    }
    @PostMapping
    @RequestMapping(value = "createAmigos", method = RequestMethod.POST)
    public ResponseEntity<?> createAmigos(@RequestBody  AmigosEntity amigos){
        AmigosEntity amigosCreados= this.service.createAmigos(amigos);
        return  ResponseEntity.status(HttpStatus.CREATED).body(amigosCreados);
    }
    @PutMapping
    @RequestMapping(value = "ModificarAmigos", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarAmigos(@RequestBody  AmigosEntity amigos){
        AmigosEntity  amigosModificados = this.service.ModificarAmigos(amigos);
        return  ResponseEntity.status(HttpStatus.CREATED).body( amigosModificados);
    }

    @GetMapping
    @RequestMapping(value = "BuscarAmigos/{idAmistad}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarAmigos(@PathVariable int idAmistad){
        AmigosEntity publicationbuscada= this.service. BuscarAmigos(idAmistad);
        return  ResponseEntity.ok(publicationbuscada);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarAmigos/{idAmistad}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarAmigos(@PathVariable int idAmistad){
        this.service.EliminarAmigos(idAmistad);
        return  ResponseEntity.ok().build();
    }


}
