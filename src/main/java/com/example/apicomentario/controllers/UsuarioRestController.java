package com.example.apicomentario.controllers;
import com.example.apicomentario.models.Usuario;
import com.example.apicomentario.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaUsuario() {
        List<Usuario> mostrarListaUsuario = usuarioService.listOfUsers();
        return mostrarListaUsuario;
    }

    @GetMapping("/buscar/email") //localhost:8080/usuario/buscar/email?usuarioEmail=i.lyon.graf@gmail.com
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String usuarioEmail) {
        Usuario usuario = usuarioService.findUserByEmailQS(usuarioEmail);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario nuevoUsuario) {
        Usuario usuarioGuardar = usuarioService.saveUser(nuevoUsuario);
        return usuarioGuardar;
    }

    @DeleteMapping("/borrar/email")//localhost:8080/usuario/borrar/email?usuarioEmail=i.lyon.graf@gmail.com
    public ResponseEntity<Void> borrarUsuarioPorEmail(@RequestParam String usuarioEmail) {
        boolean usuarioBorrado = usuarioService.deleteUserByEmailQS(usuarioEmail);

        if (usuarioBorrado) {
            // El usuario se borró correctamente (código de estado 204 No Content)
            return ResponseEntity.noContent().build();
        } else {
            // El usuario no se encontró o no se pudo borrar (código de estado 404 Not Found)
            return ResponseEntity.notFound().build();
        }
    }


}
