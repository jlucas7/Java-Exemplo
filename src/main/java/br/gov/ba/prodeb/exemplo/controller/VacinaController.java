package br.gov.ba.prodeb.exemplo.controller;

import br.gov.ba.prodeb.exemplo.dto.VacinaDTO;
import br.gov.ba.prodeb.exemplo.entity.Vacina;
import br.gov.ba.prodeb.exemplo.respose.VacinaResponse;
import br.gov.ba.prodeb.exemplo.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    VacinaService vacinaService;

    @GetMapping()
    public List<Vacina> listagem() {
        return vacinaService.obterTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacinaResponse> ver(@PathVariable String id) {
        Optional<Vacina> vacinaOptional = vacinaService.obterVacina(id);

        if (vacinaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new VacinaResponse(vacinaOptional.get()));
    }

    @PostMapping()
    public ResponseEntity<Vacina> inserir(@RequestBody @Valid VacinaDTO vacinaDTO, UriComponentsBuilder uriComponentsBuilder) {
        Vacina vacina = vacinaService.inserirVacina(new Vacina(vacinaDTO));

        URI uri = uriComponentsBuilder.path("/vacinas/{id}").buildAndExpand(vacina.getId()).toUri();

        return ResponseEntity.created(uri).body(vacina);
    }

    @PutMapping("/{id}")
    public Vacina atualizar(@RequestBody VacinaDTO vacinaDTO, @PathVariable String id) {
        try {
            vacinaDTO.setId(id);
            return vacinaService.atualizarVacina(new Vacina(vacinaDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable String id) {
        try {
            vacinaService.removerVacina(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "";
    }

}
