package com.ecodeup.biblioteca.controller;

import com.ecodeup.biblioteca.dto.AutorDTO;
import com.ecodeup.biblioteca.dto.LibroDTO;
import com.ecodeup.biblioteca.service.AutorService;
import com.ecodeup.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<LibroDTO> save(@RequestBody LibroDTO libroDTO){
        return new ResponseEntity<>(libroService.save(libroDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<LibroDTO>> findAll(){
    return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <LibroDTO> findbyId(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(libroService.findById(id), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <LibroDTO> detelebyId(@PathVariable Integer id){
        try{

            libroService.deletebyId(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
