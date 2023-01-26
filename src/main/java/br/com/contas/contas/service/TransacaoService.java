package br.com.contas.contas.service;

import br.com.contas.contas.model.Transacao;
import br.com.contas.contas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    public void save(final Transacao transacao) {
        repository.save(transacao);
    }
}
