package br.gov.ba.prodeb.exemplo.respose;

import br.gov.ba.prodeb.exemplo.entity.Vacina;
import br.gov.ba.prodeb.exemplo.entity.Vacinacao;
import lombok.Data;

@Data
public class VacinacaoResponse {
    private String id;

    public VacinacaoResponse(Vacinacao vacinacao) {
        id = vacinacao.getId();
    }
}
