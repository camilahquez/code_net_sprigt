package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.PublicationEntity;
import com.example.code_net_mongodb.Entity.UserEntity;
import com.example.code_net_mongodb.Service.PublicationService;
import com.example.code_net_mongodb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
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
    @PostMapping
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
    @RequestMapping(value = "BuscarPublication/{idPublicacion}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPublication(@PathVariable int idPublicacion){
        PublicationEntity publicationbuscada= this.service.BuscarPublication(idPublicacion);
        return  ResponseEntity.ok(publicationbuscada);
    }
    @GetMapping
    @RequestMapping(value = "BuscarPublicationByTypePublication/{typePublication}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPublicationByTypePublication(@PathVariable String typePublication){
        List<PublicationEntity> publicationbuscadaByType= this.service.BuscarPublicationByTipePublication(typePublication);
        return  ResponseEntity.ok(publicationbuscadaByType);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarPublication/{idPubliacacion}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPublication(@PathVariable int idPublicacion){
        this.service.EliminarPublication(idPublicacion);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/Publication")
    @RequestMapping(value = "publicationByIdUser/{idUsuario}/{page}/{size}", method = RequestMethod.GET)
    public Page<PublicationEntity> publicationByIdUsuario(@PathVariable int idUsuario, @PathVariable int page, @PathVariable int size) {
        return service.publicationByIdUser(idUsuario, page, size);
    }

}
