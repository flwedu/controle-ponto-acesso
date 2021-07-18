package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.NivelAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Long> {
}
