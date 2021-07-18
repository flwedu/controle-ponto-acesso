package com.dio.controlepontoacesso.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Movimentacao {

    /*Cria um id composto (2 chaves de Id)*/
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    }

    @Id
    @EmbeddedId
    private MovimentacaoId id;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodoPermanencia;

    @ManyToOne
    private Ocorrencia ocorrencia;
    @ManyToOne
    private Calendario calendario;
}
