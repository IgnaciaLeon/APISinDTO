package com.example.apicomentario.repositories;

import com.example.apicomentario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select * from usuario", nativeQuery = true)
    String deleteUserByEmailQS (String usuarioEmail);
    @Query(value = "select * from usuario", nativeQuery = true)
    Boolean existsUserByEmailQB (Boolean usuarioEmail);
    @Query(value = "select * from usuario", nativeQuery = true)
    Usuario findUserByEmailQS (String usuarioEmail);

}
