package com.ecodeup.biblioteca.dto;

import com.ecodeup.biblioteca.model.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellidos = autor.getApellidos();
        this.telefono = autor.getTelefono();
    }
}
