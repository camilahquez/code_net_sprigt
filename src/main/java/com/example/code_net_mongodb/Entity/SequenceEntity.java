package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//para generar los id
@Getter
@Setter
@Document(collection = "sequence")
public class SequenceEntity {
    @Id
    @NotNull
    private String collectionName;
    private int sequence;
}
