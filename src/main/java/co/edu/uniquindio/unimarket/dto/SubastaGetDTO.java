package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubastaGetDTO {
    private Long idSubasta;
    private boolean estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double valorInicial;
    private Long idUsuario;
    private Long idProducto;
    private List<PujaDTO> pujas;
}