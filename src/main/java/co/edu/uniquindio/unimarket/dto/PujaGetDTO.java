package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PujaGetDTO {
    private Long idPuja;
    private double valorPuja;
    private Long idUsuario;
    private Long idSubasta;
}
