package com.example.apicomentario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Usuario {
    @Id
    @Column (name = "email")
    private String usuarioEmail;

    @Column (name = "token")
    private String usuarioToken;

    @Column (name = "nombre")
    private String usuarioNombre;

    @Column (name = "imagen")
    private String usuarioImagen;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Post> postsUsuario;

   //@JsonIgnore
    @CreationTimestamp
    private LocalDateTime UsuarioFechaCreado;

   @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime UsuarioFechaActualizado;

}

//preguntar si el avatar va aqui o en post y comentarios




