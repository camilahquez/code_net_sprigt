package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Document(collection = "comments")
public class CommentsEntity {
    @Id
    private int id;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int idUsuario;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int idPublicacion;
    private LocalDateTime dateCommets;
    private String message;

}
