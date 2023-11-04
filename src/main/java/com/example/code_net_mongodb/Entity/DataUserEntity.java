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
@Document(collection = "data_user")
public class DataUserEntity {
    @Id
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int id;
    @NotNull
    @Min(value= 1, message = "El ID debe de ser un valor posittivo")
    private int idUser ;
    @NotNull
    private String nickname;
    @NotNull
    private String name;
    @NotNull
    private String lastname;

    private String address;
    @NotNull
    private String phoneNumber;
    @NotNull
    private Date dateBirth;
    @NotNull
    private String genero;

}
