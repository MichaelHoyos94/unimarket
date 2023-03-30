package co.edu.uniquindio.unimarket.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubastaGetDTO {
    private Long idSubasta;
    private String nombreProducto;
    private String descripcion;
    private Boolean estado;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private double valorInicial;
    private Long idUsuario;
    private List<PujaDTO> pujas;
}