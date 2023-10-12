package br.com.udemy.cursoudemy.services;

import br.com.udemy.cursoudemy.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("buscando um person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setPrimeiroNome("Wagner");
        person.setUltimoNome("Cardoso");
        person.setEndereco("Valparaiso - Goiás - Brasil");
        person.setGenero("Masculino");
        return person;
    }
}
