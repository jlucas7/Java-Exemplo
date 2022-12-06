package br.gov.ba.prodeb.exemplo.respose;

import br.gov.ba.prodeb.exemplo.entity.Vacina;
import lombok.Data;

@Data
public class VacinaResponse {
    private String fabricante;

    public VacinaResponse(Vacina vacina) {
        fabricante = vacina.getFabricante();
    }
}
