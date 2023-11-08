package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "amigos")
public class AmigosEntity {
    @Id
    private int id;
    @NotNull
    private int idUsuario;
    @NotNull
    private int idAmigo;
    private LocalDateTime dateAmistad;




}
