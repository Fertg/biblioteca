package com.ecodeup.biblioteca.model;

import com.ecodeup.biblioteca.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //Constructor lleno
@NoArgsConstructor //contructor vacio
@Data //crea Getters y Setters
@Entity
@Table(name="autores") //nombre de la tabla en bbdd
public class Autor {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;

    public Autor(AutorDTO autorDTO) {
        this.id = autorDTO.getId();
        this.nombre = autorDTO.getNombre();
        this.apellidos = autorDTO.getApellidos();
        this.telefono = autorDTO.getTelefono();
    }
}
