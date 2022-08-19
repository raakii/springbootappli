package com.example.springboot.service;

import com.example.springboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    Person create(Person person);
    List<Person> createAll(List<Person> persons);
    Optional<Person> getPerson(Long id);
    Person getPersonByFirstnameAndLastname(String firstname, String lastname);
    List<Person> getAllPerson();
    void deletePerson(Long id);

    Person modifyPerson(Long id, Person person);

}
