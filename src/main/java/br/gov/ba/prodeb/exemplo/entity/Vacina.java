package br.gov.ba.prodeb.exemplo.entity;

import br.gov.ba.prodeb.exemplo.dto.VacinaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Vacina {
    @Id
    private String id;

    private String fabricante;

    private int lote;

    private String dataValidade;

    private int numeroDoses;

    private int intervaloMinimoDoses;


    public Vacina(VacinaDTO vacinaDTO) {
        id = vacinaDTO.getId();
        fabricante = vacinaDTO.getFabricante();
        lote = vacinaDTO.getLote();
        dataValidade = vacinaDTO.getDataValidade();
        numeroDoses = vacinaDTO.getNumeroDoses();
        intervaloMinimoDoses = vacinaDTO.getIntervaloMinimoDoses();
    }
}
