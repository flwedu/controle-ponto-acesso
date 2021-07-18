package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.CategoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaUsuarioRepository extends JpaRepository<CategoriaUsuario, Long> {
}
