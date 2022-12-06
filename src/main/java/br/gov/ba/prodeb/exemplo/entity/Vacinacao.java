package br.gov.ba.prodeb.exemplo.entity;

import br.gov.ba.prodeb.exemplo.dto.VacinacaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Vacinacao {
    @Id
    private String id;

    private String dataVacinacao;

    private int dose;

    private Pessoa pessoa;

    private Vacina vacina;


    public Vacinacao(VacinacaoDTO vacinacaoDTO) {
        id = vacinacaoDTO.getId();
        dataVacinacao = vacinacaoDTO.getDataVacinacao();
        dose = vacinacaoDTO.getDose();
        pessoa = vacinacaoDTO.getPessoa();
        vacina = vacinacaoDTO.getVacina();
    }
}
