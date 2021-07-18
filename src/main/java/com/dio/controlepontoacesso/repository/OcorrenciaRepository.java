package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}
