package br.com.contas.contas.controller;

import br.com.contas.contas.model.Transacao;
import br.com.contas.contas.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao/")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Transacao save(@RequestBody Transacao transacao){
        return transacaoService.save(transacao);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Transacao findById(@RequestParam String id){
        return transacaoService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/findAll", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Transacao> findAll(){
        return transacaoService.findAll();
    }
}
