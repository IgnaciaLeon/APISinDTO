package com.example.apicomentario.services;

import com.example.apicomentario.models.Post;

public interface PostService {

    Post savePost(Post postNuevo);
    //Post meGustaPost(Long id, Post postMeGustaActualizado);
    String findPostByEmailQS1 (String usuarioEmail);
    String findPostByEmailQS2 (String usuarioEmail);
    String deletePostByEmailQS (String usuarioEmail);
    Boolean deletePostByEmailQB (Boolean usuarioEmail);
    Post findByEmail (String usuarioEmail);

    //QUERY EDIT POST BY EMAIL

}
