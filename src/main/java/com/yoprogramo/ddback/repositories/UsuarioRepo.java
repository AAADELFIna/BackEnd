package com.yoprogramo.ddback.repositories;

import com.yoprogramo.ddback.models.Experiencia;
import com.yoprogramo.ddback.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepo extends JpaRepository<Experiencia, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.username = :username AND password = :password")
    Usuario login(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    Usuario logout(@Param("username") String username);
}
