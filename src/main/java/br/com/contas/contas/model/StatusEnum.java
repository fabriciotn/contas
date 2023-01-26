package br.com.contas.contas.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {

    PAGO("Pago"),
    PENDENTE("Pendente");

    private String descricao;
}
