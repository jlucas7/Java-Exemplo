package br.gov.ba.prodeb.exemplo.controller;

import br.gov.ba.prodeb.exemplo.dto.VacinacaoDTO;
import br.gov.ba.prodeb.exemplo.entity.Vacinacao;
import br.gov.ba.prodeb.exemplo.respose.VacinacaoResponse;
import br.gov.ba.prodeb.exemplo.service.VacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacinacao")
public class VacinacaoController {

    @Autowired
    VacinacaoService vacinacaoService;

    @GetMapping()
    public List<Vacinacao> listagem() {
        return vacinacaoService.obterTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacinacaoResponse> ver(@PathVariable String id) {
        Optional<Vacinacao> vacinacaoOptional = vacinacaoService.obterVacinacao(id);

        if (vacinacaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new VacinacaoResponse(vacinacaoOptional.get()));
    }

    @PostMapping()
    public ResponseEntity<Vacinacao> inserir(@RequestBody @Valid VacinacaoDTO vacinacaoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Vacinacao vacinacao = vacinacaoService.inserirVacinacao(new Vacinacao(vacinacaoDTO));

        URI uri = uriComponentsBuilder.path("/vacinacao/{id}").buildAndExpand(vacinacao.getId()).toUri();

        return ResponseEntity.created(uri).body(vacinacao);
    }

    @PutMapping("/{id}")
    public Vacinacao atualizar(@RequestBody VacinacaoDTO vacinacaoDTO, @PathVariable String id) {
        try {
            vacinacaoDTO.setId(id);
            return vacinacaoService.atualizarVacinacao(new Vacinacao(vacinacaoDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable String id) {
        try {
            vacinacaoService.removerVacinacao(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "";
    }

}
