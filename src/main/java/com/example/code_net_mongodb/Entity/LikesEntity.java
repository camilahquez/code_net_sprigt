package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "likes")
public class LikesEntity {
    @Id
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int id;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int idUser;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int idPublication ;
    @NotNull
    private Date dateLike;

}
