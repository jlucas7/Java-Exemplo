package br.gov.ba.prodeb.exemplo.dto;

import br.gov.ba.prodeb.exemplo.entity.Pessoa;
import br.gov.ba.prodeb.exemplo.entity.Vacina;
import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class VacinacaoDTO {
    @Transient
    private String id;
    private String dataVacinacao;
    private int dose;
    private Pessoa pessoa;
    private Vacina vacina;
}
