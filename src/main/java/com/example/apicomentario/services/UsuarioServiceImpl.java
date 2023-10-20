package com.example.apicomentario.services;
import com.example.apicomentario.models.Usuario;
import com.example.apicomentario.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listOfUsers() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
    }

    @Override
    public Usuario findUserByEmailQS(String usuarioEmail) {
        Boolean existeUsuario = usuarioRepository.existsUserByEmailQB(Boolean.valueOf(usuarioEmail));
        if (existeUsuario) {
            Usuario usuarioEscogido = usuarioRepository.findUserByEmailQS(usuarioEmail);
            return usuarioEscogido;
        } else {
            System.out.println("usuario inválido o inexistente");
            return null;
        }

    }
    @Override
    public Usuario saveUser(Usuario usuarioNuevo) {
        Usuario usuarioGuardado = usuarioRepository.save(usuarioNuevo);
        return usuarioGuardado;
    }
    @Override
    public Boolean deleteUserByEmailQS(String usuarioEmail) {
        usuarioRepository.deleteUserByEmailQS(usuarioEmail);
        return true;
    }


    }
