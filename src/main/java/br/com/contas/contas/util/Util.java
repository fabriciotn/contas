package br.com.contas.contas.util;

import br.com.contas.contas.model.Transacao;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Util {

    public static String montarDataReferencia(Transacao transacao) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MM-yyyy");
        return formatter.format(transacao.getDataPagamento());
    }
}
