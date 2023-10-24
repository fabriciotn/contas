package br.com.contas.contas.service;

import br.com.contas.contas.model.Transacao;
import br.com.contas.contas.repository.TransacaoRepository;
import br.com.contas.contas.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransacaoService {

    public static final String TRANSACAO = "TRANSACAO";
    @Autowired
    private TransacaoRepository repository;

    public Transacao save(final Transacao transacao) {
        transacao.setId(UUID.randomUUID().toString());
        transacao.setSort(TRANSACAO);
        transacao.setDataReferencia(Util.montarDataReferencia(transacao));
        return repository.save(transacao);
    }

    public Transacao findById(String id) {
        return repository.findByID(id);
    }

    public List<Transacao> findAll() {
        return repository.findAll();
    }
}
