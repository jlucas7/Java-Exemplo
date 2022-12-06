package br.gov.ba.prodeb.exemplo.respose;

import br.gov.ba.prodeb.exemplo.entity.Pessoa;
import lombok.Data;

@Data
public class PessoaResponse {
    private String nome;

    public PessoaResponse(Pessoa pessoa) {
        nome = pessoa.getNome();
    }
}
