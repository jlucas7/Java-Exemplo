package br.gov.ba.prodeb.exemplo.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Date;

@Data
public class VacinaDTO {
    @Transient
    private String id;
    private String fabricante;
    private int lote;
    private String dataValidade;
    private int numeroDoses;
    private int intervaloMinimoDoses;
}
