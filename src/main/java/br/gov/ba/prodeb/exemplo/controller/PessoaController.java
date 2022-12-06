package br.gov.ba.prodeb.exemplo.controller;

import br.gov.ba.prodeb.exemplo.dto.PessoaDTO;
import br.gov.ba.prodeb.exemplo.entity.Pessoa;
import br.gov.ba.prodeb.exemplo.respose.PessoaResponse;
import br.gov.ba.prodeb.exemplo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping()
    public List<Pessoa> listagem() {
        return pessoaService.obterTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> ver(@PathVariable String id) {
        Optional<Pessoa> pessoaOptional = pessoaService.obterPessoa(id);

        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new PessoaResponse(pessoaOptional.get()));
    }

    @PostMapping()
    public ResponseEntity<Pessoa> inserir(@RequestBody @Valid PessoaDTO pessoaDTO, UriComponentsBuilder uriComponentsBuilder) {
        Pessoa pessoa = pessoaService.inserirPessoa(new Pessoa(pessoaDTO));

        URI uri = uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@RequestBody PessoaDTO pessoaDTO, @PathVariable String id) {
        try {
            pessoaDTO.setId(id);
            return pessoaService.atualizarPessoa(new Pessoa(pessoaDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable String id) {
        try {
            pessoaService.removerPessoa(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "";
    }

}
