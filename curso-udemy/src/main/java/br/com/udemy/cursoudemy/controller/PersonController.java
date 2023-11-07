package br.com.udemy.cursoudemy.controller;

import br.com.udemy.cursoudemy.data.vo.v1.PersonVO;
import br.com.udemy.cursoudemy.data.vo.v2.v1.PersonVOV2;
import br.com.udemy.cursoudemy.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private PersonServices services;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findyById(
            @PathVariable(value = "id")Long id ){
        return services.findById(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List <PersonVO> findAll(){
        return services.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(
            @RequestBody PersonVO person){
        return services.create(person);
    }

    @PostMapping(value = "/v2",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(
            @RequestBody PersonVOV2 person){
        return services.createV2(person);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(
            @RequestBody PersonVO person){
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id")Long id ){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }


}
