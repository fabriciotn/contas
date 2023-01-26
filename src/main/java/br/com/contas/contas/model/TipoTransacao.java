package br.com.contas.contas.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoTransacao {

    CONTA_RECEBER("Conta à receber"),
    CONTA_PAGAR("Conta à pagar");

    private String descricao;
}
