package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.LikesEntity;
import com.example.code_net_mongodb.Service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikesController {

    private final LikesService service;

    @Autowired
    public LikesController(LikesService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping(value = "consultarLikes", method = RequestMethod.GET)
    public ResponseEntity<?> consultarLikes() {
        List<LikesEntity> likesList = this.service.consultarLikes();
        return ResponseEntity.ok(likesList);
    }

    @PostMapping
    @RequestMapping(value = "createLikes", method = RequestMethod.POST)
    public ResponseEntity<?> createLikes(@RequestBody LikesEntity like) {
        LikesEntity likesCreado = this.service.createLikes(like);
        return ResponseEntity.status(HttpStatus.CREATED).body(likesCreado);
    }

    @PutMapping
    @RequestMapping(value = "ModificarLikes", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarLikes(@RequestBody LikesEntity like) {
        LikesEntity likeModificado = this.service.ModificarLikes(like);
        return ResponseEntity.status(HttpStatus.CREATED).body(likeModificado);
    }

    @GetMapping
    @RequestMapping(value = "BuscarLikes/{idPubliacacion}/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarLikes(@PathVariable int idPublicacion, @PathVariable int idUsuario) {
        LikesEntity likebuscado = this.service.BuscarLikes(idPublicacion, idUsuario);
        return ResponseEntity.ok(likebuscado);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarLikes/{idPubliacacion}/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarLikes(@PathVariable int idPublicacion, @PathVariable int idUsuario) {
        this.service.EliminarLikes(idPublicacion, idUsuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @RequestMapping(value = "likesByIdPublication/{idPublication}/{page}/{size}", method = RequestMethod.GET)
    public Page<LikesEntity> likesByIdPublicationr(@PathVariable int idPublicacion, @PathVariable int page, @PathVariable int size) {
        return service.likesByIdPublication(idPublicacion, page, size);
    }

}
