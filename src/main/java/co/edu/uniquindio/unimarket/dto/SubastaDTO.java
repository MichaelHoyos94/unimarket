package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubastaDTO {
    private LocalDate fechaFin;
    private double valorInicial;
    private Long idUsuario;
    private Long idProducto;
}