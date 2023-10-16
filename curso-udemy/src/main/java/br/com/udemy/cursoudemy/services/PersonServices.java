package br.com.udemy.cursoudemy.services;

import br.com.udemy.cursoudemy.exceptions.ResourceNotFoundException;
import br.com.udemy.cursoudemy.model.Person;
import br.com.udemy.cursoudemy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){

        return repository.findAll();
    }


    public Person findById(Long id){
        logger.info("buscando um person!");

        Person person = new Person();
        person.setPrimeiroNome("Wagner");
        person.setUltimoNome("Cardoso");
        person.setEndereco("Valparaiso - Goiás - Brasil");
        person.setGenero("Masculino");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person nao encontrado"));
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setPrimeiroNome("Person nome " + i);
        person.setUltimoNome("Ultimo nome " + i);
        person.setEndereco("Llgum endereço no Brasil " + i);
        person.setGenero("Masculino");
        return person;
    }

    public Person create(Person person){

        logger.info("creando um person!");
        return repository.save(person);
    }

    public Person update(Person person){

        logger.info("atualizando um person!");
        Person person1 = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        person1.setPrimeiroNome(person.getPrimeiroNome());
        person1.setUltimoNome(person.getUltimoNome() );
        person1.setEndereco(person.getEndereco() );
        person1.setGenero(person.getGenero());
        return repository.save(person);
    }
    public void delete(Long id){

        logger.info("atualizando um person!");
        Person person1 = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        repository.delete(person1);



    }
}
