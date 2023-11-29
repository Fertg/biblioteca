package com.ecodeup.biblioteca.service;

import com.ecodeup.biblioteca.dto.AutorDTO;
import com.ecodeup.biblioteca.dto.LibroDTO;
import com.ecodeup.biblioteca.model.Autor;
import com.ecodeup.biblioteca.repository.AutorRepository;
import com.ecodeup.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private FabricaLibrosService fabricaLibrosService;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private FabricaAutorService fabricaAutorService;
    public LibroDTO save (LibroDTO libroDTO){
        Autor autor= autorRepository.findById(libroDTO.getIdAutor()).get();
        libroDTO.setAutorDTO(fabricaAutorService.crearAutorDTO(autor));
        return  fabricaLibrosService.crearLibroDTO(libroRepository.save(fabricaLibrosService.crearLibro(libroDTO)));
    }

    public List<LibroDTO> findAll(){
        return fabricaLibrosService.crearLibrosDTO(libroRepository.findAll());
    }
    public LibroDTO findById (Integer id){
        return fabricaLibrosService.crearLibroDTO(libroRepository.findById(id).get());
    }

    public void deletebyId(Integer id){
        libroRepository.deleteById(id);
    }




}
