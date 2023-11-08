package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Document(collection = "publication")
public class PublicationEntity {
    @Id
    private int id;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int idUsuario;
    @NotNull
    private ArrayList<String> linkPublication;
    @NotNull
    private String typePublication;
    //no se ingresa
    private LocalDateTime datePublication;
    private String message;
    private ArrayList<String> tecnologias;
}
