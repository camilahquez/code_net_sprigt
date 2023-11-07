package com.example.code_net_mongodb.Service;

import com.example.code_net_mongodb.Entity.SequenceEntity;
import com.example.code_net_mongodb.Repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SequenceService {
    private SequenceRepository sequenceRepository;

    @Autowired
    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public SequenceEntity createSequence(SequenceEntity sequence) {
        return sequenceRepository.save(sequence);
    }

    public SequenceEntity getSequenceByCollectionName(String collectionName) {
        return sequenceRepository.findByCollectionName(collectionName);
    }

    public SequenceEntity updateSequence(SequenceEntity sequence) {
        if (sequenceRepository.existsByCollectionName(sequence.getCollectionName())) {
            return sequenceRepository.save(sequence);
        } else {
            throw new NoSuchElementException("Secuencia no encontrada");
        }
    }

    public void deleteSequenceByCollectionName(String collectionName) {
        sequenceRepository.deleteByCollectionName(collectionName);
    }

    public int getNextId(String collectionName){
        SequenceEntity sequence = sequenceRepository.findByCollectionName(collectionName);
        if(sequence == null) {
            sequence = new SequenceEntity();
            sequence.setCollectionName(collectionName);
        }
        sequence.setSequence(sequence.getSequence() + 1);

        sequenceRepository.save(sequence);
        return sequence.getSequence();
    }
}
