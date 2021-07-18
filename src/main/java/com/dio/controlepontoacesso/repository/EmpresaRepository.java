package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
