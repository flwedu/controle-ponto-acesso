package com.dio.controlepontoacesso.repository;

import java.util.Optional;

import com.dio.controlepontoacesso.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Movimentacao.MovimentacaoId> {

    Optional<Movimentacao> findByIdIdMovimento(long id);

    void deleteByIdIdMovimento(long id);
}
