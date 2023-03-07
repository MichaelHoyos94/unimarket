package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario extends Persona implements Serializable {

}