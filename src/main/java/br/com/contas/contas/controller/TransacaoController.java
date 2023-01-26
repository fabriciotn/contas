package br.com.contas.contas.controller;

import br.com.contas.contas.model.Transacao;
import br.com.contas.contas.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/transacao/")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Transacao transacao){
        transacao.setId(UUID.randomUUID().toString());
        transacao.setSort("TRANSACAO");

        transacaoService.save(transacao);
    }
}
