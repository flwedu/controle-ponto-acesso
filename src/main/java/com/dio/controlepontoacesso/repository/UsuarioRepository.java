package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
