package br.com.udemy.cursoudemy.mapper.custom;

import br.com.udemy.cursoudemy.data.vo.v2.v1.PersonVOV2;
import br.com.udemy.cursoudemy.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setPrimeiroNome(person.getPrimeiroNome());
        vo.setUltimoNome(person.getUltimoNome());
        vo.setEndereco(person.getEndereco());
        vo.setGenero(person.getGenero());
        vo.setDataNascimento(new Date());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person){
        Person  entity = new Person();
        entity.setId(person.getId());
        entity.setPrimeiroNome(person.getPrimeiroNome());
        entity.setUltimoNome(person.getUltimoNome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
//        vo.setDataNascimento(new Date());
        return entity;
    }
}
