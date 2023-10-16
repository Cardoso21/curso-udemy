package br.com.udemy.cursoudemy.controller;

import br.com.udemy.cursoudemy.model.Person;
import br.com.udemy.cursoudemy.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private PersonServices services;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findyById(
            @PathVariable(value = "id")Long id ){
        return services.findById(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Person> findyAll(){
        return services.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(
            @RequestBody Person person){
        return services.create(person);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(
            @RequestBody Person person){
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id")Long id ){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }


}
