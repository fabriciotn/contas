package br.com.contas.contas.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FormaPagamentoEnum {

    CONTA_CORRENTE("Conta Corrente"),
    CARTAO_CREDITO("Cartão de Crédito"),
    PIX("PIX"),
    DINHEIRO("Dinheiro"),
    TED("TED"),
    BOLETO("Boleto");

    private String descricao;
}
