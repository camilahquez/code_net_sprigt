package com.example.code_net_mongodb.Controller;

import com.example.code_net_mongodb.Entity.SequenceEntity;
import com.example.code_net_mongodb.Service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SequenceController {

    private final SequenceService sequenceService;

    @Autowired
    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @PostMapping
    @RequestMapping(value = "CrearSequencia", method = RequestMethod.POST)
    public SequenceEntity createSequence(@RequestBody SequenceEntity sequence) {
        return sequenceService.createSequence(sequence);
    }

    @GetMapping
    @RequestMapping(value = "BuscarSequencia/{collectionName}", method = RequestMethod.GET)
    public SequenceEntity getSequenceByCollectionName(@PathVariable String collectionName) {
        return sequenceService.getSequenceByCollectionName(collectionName);
    }

    @PutMapping
    @RequestMapping(value = "ModificarSequencia/{collectionName}", method = RequestMethod.PUT)
    public SequenceEntity updateSequence(@PathVariable String collectionName, @RequestBody SequenceEntity sequence) {
        sequence.setCollectionName(collectionName);
        return sequenceService.updateSequence(sequence);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarSequencia/{collectionName}", method = RequestMethod.DELETE)
    public void deleteSequenceByCollectionName(@PathVariable String collectionName) {
        sequenceService.deleteSequenceByCollectionName(collectionName);
    }

    @GetMapping
    @RequestMapping(value = "NextID/{collectionName}", method = RequestMethod.GET)
    public int nextID(@PathVariable String collectionName) {
        return sequenceService.getNextId(collectionName);
    }
}
