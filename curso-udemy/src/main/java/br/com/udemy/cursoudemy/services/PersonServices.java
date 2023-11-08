package br.com.udemy.cursoudemy.services;

import br.com.udemy.cursoudemy.controller.PersonController;
import br.com.udemy.cursoudemy.data.vo.v1.PersonVO;
import br.com.udemy.cursoudemy.exceptions.ResourceNotFoundException;
import br.com.udemy.cursoudemy.mapper.DozerMapper;
import br.com.udemy.cursoudemy.model.Person;
import br.com.udemy.cursoudemy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    public List<PersonVO> findAll() {

        logger.info("buscando todos os persons! ");

        var persons = DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findyById(p.getKey())).withSelfRel()));
        return persons;
    }

    public PersonVO findById(Long id){
        logger.info("buscando um person!");

        var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person nao encontrado"));
       PersonVO vo = DozerMapper.parseObject(entity,PersonVO.class);
       vo.add(linkTo(methodOn(PersonController.class).findyById(id)).withSelfRel());
       return vo;
    }



    public PersonVO create(PersonVO personvo){

        logger.info("creando um person!");

        var entity =DozerMapper.parseObject(personvo, Person.class);
        PersonVO vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findyById(vo.getKey())).withSelfRel());
        return vo;

    }

    public PersonVO update(PersonVO person){

        logger.info("atualizando um person!");
        Person person1 = repository.findById(person.getKey()).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        person1.setPrimeiroNome(person.getPrimeiroNome());
        person1.setUltimoNome(person.getUltimoNome() );
        person1.setEndereco(person.getEndereco() );
        person1.setGenero(person.getGenero());

        PersonVO vo = DozerMapper.parseObject(repository.save(person1),PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findyById(vo.getKey())).withSelfRel());
        return vo;
    }
    public void delete(Long id){

        logger.info("atualizando um person!");
        Person person1 = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id nao encontrado"));
        repository.delete(person1);



    }
}
