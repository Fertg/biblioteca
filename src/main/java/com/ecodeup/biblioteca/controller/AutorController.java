package com.ecodeup.biblioteca.controller;

import com.ecodeup.biblioteca.dto.AutorDTO;
import com.ecodeup.biblioteca.service.AutorService;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorDTO> save(@RequestBody AutorDTO autorDTO){
        return new ResponseEntity<>(autorService.save(autorDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<AutorDTO>> findAll(){
    return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <AutorDTO> findbyId(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(autorService.findById(id), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <AutorDTO> detelebyId(@PathVariable Integer id){
        try{

            autorService.deletebyId(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
