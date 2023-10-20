package com.example.apicomentario.controllers;

import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.PostRepository;
import com.example.apicomentario.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    PostRepository postRepository;
    @GetMapping("/lista")
    public List<Post> listaPostPorFecha() {
        List<Post> mostrarListaPostPorFecha = postService.findPostByPostFechacreado();
        return mostrarListaPostPorFecha;
    }

    @PostMapping("/guardar")
    public Post guardarPost(@RequestBody Post nuevoPost) {
        Post postGuardar = postService.savePost(nuevoPost);
        return postGuardar;
    }

    @GetMapping("/buscar/email")
    public ResponseEntity<Post> buscarPostPorEmail (@RequestParam String usuarioEmail) {
        Post post = postService.findByEmail(usuarioEmail);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrar/email")
    public ResponseEntity<Void> borrarPostPorEmail(@RequestParam String usuarioEmail) {
        boolean postBorrado = postService.deletePostByEmailQB(Boolean.valueOf(usuarioEmail));

        if (postBorrado) {
            // El post se borró correctamente (código de estado 204 No Content)
            return ResponseEntity.noContent().build();
        } else {
            // El post no se encontró o no se pudo borrar (código de estado 404 Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    /*@PutMapping("/editar/email")//localhost:8080/post/editar/email?usuarioEmail=i.lyon.graf@gmail.com
    public Post editarPostPorEmail(@RequestParam String usuarioEmail, @RequestBody Post postActualizado){
        Post postEditado = postService.editarPostPorEmail(String usuarioEmail, Post postActualizado);
        return postEditado;

    }

     */

  /*EDIT  @PutMapping("/editar/{id}")
    public Post editarPostPorId(@PathVariable Long id, @RequestBody Post postActualizado){
        Post postEditado = postService.editarPostPorId(id, postActualizado);
        return postEditado;
        */


    //LIKES CON ID, CAMBIAR A EMAIL
    @PostMapping("/like/{id}")
    public Post meGustaPost(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setPostMeGusta(post.getPostMeGusta() + 1);
            postRepository.save(post);

        }
        return post;
    }

    @PostMapping("/dislike/{id}")
    public Post noMeGustaPost(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null && post.getPostMeGusta() > 0) {
            post.setPostMeGusta(post.getPostMeGusta() - 1);
            postRepository.save(post);
        }
        return post;
    }
}
