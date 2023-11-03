package br.com.udemy.cursoudemy.services;

import br.com.udemy.cursoudemy.data.vo.v1.PersonVO;
import br.com.udemy.cursoudemy.exceptions.ResourceNotFoundException;
import br.com.udemy.cursoudemy.mapper.DozerMapper;
import br.com.udemy.cursoudemy.model.Person;
import br.com.udemy.cursoudemy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    public List<PersonVO> findAll() {

        logger.info("buscando todos os persons! ");

        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("buscando um person!");

        var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person nao encontrado"));
        return DozerMapper.parseObject(entity,PersonVO.class);
    }



    public PersonVO create(PersonVO personvo){

        logger.info("creando um person!");

        var entity =DozerMapper.parseObject(personvo, Person.class);
        return DozerMapper.parseObject(repository.save(entity),PersonVO.class);

    }

    public PersonVO update(PersonVO person){

        logger.info("atualizando um person!");
        Person person1 = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        person1.setPrimeiroNome(person.getPrimeiroNome());
        person1.setUltimoNome(person.getUltimoNome() );
        person1.setEndereco(person.getEndereco() );
        person1.setGenero(person.getGenero());

        return DozerMapper.parseObject(repository.save(person1),PersonVO.class);
    }
    public void delete(Long id){

        logger.info("atualizando um person!");
        Person person1 = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        repository.delete(person1);



    }
}
