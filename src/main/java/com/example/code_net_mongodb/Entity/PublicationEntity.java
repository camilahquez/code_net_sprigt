package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Document(collection = "publication")
public class PublicationEntity {
    @Id
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int id;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int id_user;
    @NotNull
    private ArrayList<String> link_publication;
    @NotNull
    private String type_publication;
    @NotNull
    private Date date_publication;
    @NotNull
    private String message;

}
