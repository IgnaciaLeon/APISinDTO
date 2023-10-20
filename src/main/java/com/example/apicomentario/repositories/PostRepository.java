package com.example.apicomentario.repositories;

import com.example.apicomentario.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query(value = "select * from post order by post.fecha_creado DESC", nativeQuery= true)
    List<Post> findPostByPostFechacreado();
    @Query(value = "select * from post", nativeQuery = true)
    String findPostByEmailQS1(String usuarioEmail);
    @Query(value = "select * from post", nativeQuery = true)
    String findPostByEmailQS2(String usuarioEmail);
    @Query(value = "delete * from post where post.usuario_email = :usuarioEmail", nativeQuery = true)
    String deletePostByEmailQS (String usuarioEmail);
    @Query(value = "delete * from post where post.usuario_email = :usuarioEmail", nativeQuery = true)
    Boolean DeletePostByEmailQB (Boolean usuarioEmail);
    @Query(value = "delete * from post where post.usuario_email = :usuarioEmail", nativeQuery = true)
    String DeletePostByEmailQS (String usuarioEmail);

    //QUERY EDIT POST BY EMAIL

}
