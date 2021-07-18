package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Movimentacao.MovimentacaoId> {
}
