package br.com.udemy.cursoudemy.unittest.mocks;

import br.com.udemy.cursoudemy.data.vo.v1.PersonVO;
import br.com.udemy.cursoudemy.model.Person;

import java.util.ArrayList;
import java.util.List;


public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonVO mockVO() {
        return mockVO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setEndereco("Addres Test" + number);
        person.setPrimeiroNome("First Name Test" + number);
        person.setGenero(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setUltimoNome("Last Name Test" + number);
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setEndereco("Addres Test" + number);
        person.setPrimeiroNome("First Name Test" + number);
        person.setGenero(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setUltimoNome("Last Name Test" + number);
        return person;
    }

}
