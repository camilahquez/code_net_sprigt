package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.CommentsEntity;
import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Service.CommentsService;
import com.example.code_net_mongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    private final CommentsService service;

    @Autowired
    public CommentsController(CommentsService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarComments", method = RequestMethod.GET)
    public ResponseEntity<?> consultarComments(){
        List<CommentsEntity> commentsList = this.service.consultarComments();
        return  ResponseEntity.ok(commentsList);
    }
    @PutMapping
    @RequestMapping(value = "CreateComments", method = RequestMethod.POST)
    public ResponseEntity<?> CreateComments(@RequestBody CommentsEntity comments){
        CommentsEntity commentsCreado= this.service.createComments(comments);
        return  ResponseEntity.status(HttpStatus.CREATED).body(commentsCreado);
    }
    @PutMapping
    @RequestMapping(value = "ModificarComments", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarComments(@RequestBody  CommentsEntity comments){
        CommentsEntity  commentsModificado = this.service.ModificarComments(comments);
        return  ResponseEntity.status(HttpStatus.CREATED).body(commentsModificado);
    }

    @GetMapping
    @RequestMapping(value = "BuscarComments/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarComments(@PathVariable int id){
        CommentsEntity commentsbuscado= this.service.BuscarComments(id);
        return  ResponseEntity.ok(commentsbuscado);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarComments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarComments(@PathVariable int id){
        this.service.EliminarComments(id);
        return  ResponseEntity.ok().build();
    }

}
