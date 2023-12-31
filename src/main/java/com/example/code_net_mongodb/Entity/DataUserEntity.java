package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Document(collection = "data_user")
public class DataUserEntity {
    @Id
    @NotNull
    private String email;
    @NotNull
    private String nickname;
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    @NotNull
    private String profilePicture;
    private String address;
    private String phoneNumber;
    @NotNull
    private Date dateBirth;
    @NotNull
    private String genero;
    private ArrayList<String> linkPortada;
    private ArrayList linkFotoPerfil;

}
