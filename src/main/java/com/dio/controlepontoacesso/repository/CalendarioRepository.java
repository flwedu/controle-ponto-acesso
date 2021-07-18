package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
