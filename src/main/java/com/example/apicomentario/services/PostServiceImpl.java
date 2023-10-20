package com.example.apicomentario.services;

import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.PostRepository;
import com.example.apicomentario.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Post> findPostByPostFechacreado() {
        List<Post> listaPostPorFecha = postRepository.findPostByPostFechacreado();
        return listaPostPorFecha;
    }

    @Override
    public String findPostByEmailQS1(String usuarioEmail) {
        Boolean existePostEmail = usuarioRepository.existsUserByEmailQB(Boolean.valueOf(usuarioEmail));
        if (existePostEmail) {
            String postEmailEscogido = postRepository.findPostByEmailQS1(usuarioEmail);
            return postEmailEscogido;
        } else {
            System.out.println("post inválido o inexistente");
            return null;
        }
    }

    @Override
    public String findPostByEmailQS2 (String usuarioEmail) {
        return null;
    }

    @Override
    public Post findByEmail(String usuarioEmail) {
        return null;
    }

    @Override
    public Post savePost(Post postNuevo) {
        Post postGuardado = postRepository.save(postNuevo);
        return postGuardado;
    }

    @Override
    public String deletePostByEmailQS (String usuarioEmail) { postRepository.deletePostByEmailQS(usuarioEmail);
        return null;
    }

    @Override
    public Boolean deletePostByEmailQB (Boolean usuarioEmail) {
        return true;
    }

   /* @Override
    public Post editarPostPorId(Long id, Post postActualizado) {
        Boolean existeComentario = postRepository.existsById(id);
        if (existeComentario) {
            Post postEscogido = postRepository.findById(id).get();
            postEscogido.setPostFechacreado(postActualizado.getPostFechacreado());
            postEscogido.setPostTexto(postActualizado.getPostTexto());
            System.out.println("post actualizado");
            return postRepository.save(postEscogido);
        } else {
            System.out.println("post inexistente o invalido");
            return null;
        }
    }

    */


    /*
    @Override
    public Post editarPostPorEmail(String usuarioEmail, Post postActualizado) {
        Boolean existePost = postRepository.existsByEmail(usuarioEmail);
        if (existePost) {
            String postEscogido = postRepository.findPostByEmail(usuarioEmail);
            postEscogido.setPostFechacreado(postActualizado.getPostFechacreado());
            postEscogido.setPostTexto(postActualizado.getPostTexto());
            System.out.println("post actualizado");
            return postRepository.save(postEscogido);
        } else {
            System.out.println("post inexistente o invalido");
            return null;
        }
    }


     */





}