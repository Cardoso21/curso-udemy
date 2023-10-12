package br.com.udemy.cursoudemy.controller;

import br.com.udemy.cursoudemy.model.Person;
import br.com.udemy.cursoudemy.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private PersonServices services;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findyById(
            @PathVariable(value = "id")String id )throws Exception{

        return services.findById(id);
    }



}
