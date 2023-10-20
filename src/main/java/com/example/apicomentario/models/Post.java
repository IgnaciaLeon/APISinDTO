package com.example.apicomentario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(name = "post")
    @NotNull
    private String postTexto;

    @Column(name = "fecha_creado")
    @CreationTimestamp
    private LocalDateTime PostFechacreado;

    @Column(name = "fecha_actualizado")
    @UpdateTimestamp
    private LocalDateTime postFechaActualizado;

    @Column(name = "me_gusta")
    private Integer postMeGusta;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuarioEmail")
    private Usuario usuario;


}
