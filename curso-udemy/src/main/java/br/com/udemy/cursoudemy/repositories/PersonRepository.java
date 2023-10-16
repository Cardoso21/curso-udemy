package br.com.udemy.cursoudemy.repositories;

import br.com.udemy.cursoudemy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
