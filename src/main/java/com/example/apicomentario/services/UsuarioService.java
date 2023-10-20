package com.example.apicomentario.services;
import com.example.apicomentario.models.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listOfUsers();
    Usuario saveUser(Usuario usuarioNuevo);
    Boolean deleteUserByEmailQS (String usuarioEmail);
    Usuario findUserByEmailQS (String usuarioEmail);
    //Boolean existsUserByEmailQB(String usuarioEmail);

}
