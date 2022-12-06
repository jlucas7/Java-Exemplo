package br.gov.ba.prodeb.exemplo.entity;

import br.gov.ba.prodeb.exemplo.dto.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    private String id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @Min(18)
    @Max(65)
    private int idade;

    public Pessoa(PessoaDTO pessoaDTO) {
        id = pessoaDTO.getId();
        nome = pessoaDTO.getNome();
        idade = pessoaDTO.getIdade();
    }
}
