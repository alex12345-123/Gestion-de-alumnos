package es.etg.dam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class alumno {
    private String nombre;
    private String apellidos;
    private int edad;
}
