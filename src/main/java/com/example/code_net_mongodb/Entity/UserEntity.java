package com.example.code_net_mongodb.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@Document(collection = "user")
public class UserEntity {
    //no se ingresa
    @Id
    private int id;
    @NotNull
    @Email(message = "El correo no es valido")
    private String email;
    @NotNull
    private String password;
    //no se ingresa
    private LocalDateTime fechaCreate;
}
