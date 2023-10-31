package br.com.udemy.cursoudemy.services;

import br.com.udemy.cursoudemy.data.vo.v1.PersonVO;
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

    public List<PersonVO> findAll(){

        return repository.findAll();
    }


    public PersonVO findById(Long id){
        logger.info("buscando um person!");

        PersonVO personvo = new Person();
        personvo.setPrimeiroNome("Wagner");
        personvo.setUltimoNome("Cardoso");
        personvo.setEndereco("Valparaiso - Goiás - Brasil");
        personvo.setGenero("Masculino");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person nao encontrado"));
    }

    private PersonVO mockPerson(int i) {
        PersonVO personvo = new Person();
        personvo.setPrimeiroNome("Person nome " + i);
        personvo.setUltimoNome("Ultimo nome " + i);
        personvo.setEndereco("Llgum endereço no Brasil " + i);
        personvo.setGenero("Masculino");
        return personvo;
    }

    public PersonVO create(PersonVO person){

        logger.info("creando um person!");
        return repository.save(person);
    }

    public PersonVO update(Person person){

        logger.info("atualizando um person!");
        PersonVO person1 = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        person1.setPrimeiroNome(person.getPrimeiroNome());
        person1.setUltimoNome(person.getUltimoNome() );
        person1.setEndereco(person.getEndereco() );
        person1.setGenero(person.getGenero());
        return repository.save(person);
    }
    public void delete(Long id){

        logger.info("atualizando um person!");
        PersonVO person1 = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        repository.delete(person1);



    }
}
