package br.gov.ba.prodeb.exemplo.dto;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class PessoaDTO {
    @Transient
    private String id;
    private String nome;
    private int idade;
}
