package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.LikesEntity;
import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Service.LikesService;
import com.example.code_net_mongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LikesController {

    private final LikesService service;

    @Autowired
    public LikesController(LikesService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarLikes", method = RequestMethod.GET)
    public ResponseEntity<?> consultarLikes(){
        List<LikesEntity> likesList = this.service.consultarLikes();
        return  ResponseEntity.ok(likesList);
    }
    @PutMapping
    @RequestMapping(value = "createLikes", method = RequestMethod.POST)
    public ResponseEntity<?> createLikes(@RequestBody LikesEntity like){
        LikesEntity likesCreado= this.service.createLikes(like);
        return  ResponseEntity.status(HttpStatus.CREATED).body(likesCreado);
    }
    @PutMapping
    @RequestMapping(value = "ModificarLikes", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarLikes(@RequestBody  LikesEntity like){
        LikesEntity likeModificado = this.service.ModificarLikes(like);
        return  ResponseEntity.status(HttpStatus.CREATED).body(likeModificado);
    }

    @GetMapping
    @RequestMapping(value = "BuscarLikes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarLikes(@PathVariable int id){
        LikesEntity likebuscado= this.service. BuscarLikes(id);
        return  ResponseEntity.ok(likebuscado);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarLikes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarLikes(@PathVariable int id){
        this.service.EliminarLikes(id);
        return  ResponseEntity.ok().build();
    }

}
