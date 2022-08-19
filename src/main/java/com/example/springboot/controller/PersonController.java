package com.example.springboot.controller;

import com.example.springboot.model.Person;
import com.example.springboot.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
     private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }
    @GetMapping("/firstnlastn")
    public Person findByFirstnameAndLastname(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname){
        return personService.getPersonByFirstnameAndLastname(firstname, lastname);
    }
    @PostMapping
    public List<Person> createPerson(@RequestBody Person person){
        personService.create(person);
        return personService.getAllPerson();
    }
    @PutMapping("/{id}")
    public  List<Person> modifyPerson(@PathVariable Long id, @RequestBody  Person person){
        personService.modifyPerson(id, person);
        return personService.getAllPerson();
    }
    @DeleteMapping("/{id}")
    public List<Person> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return personService.getAllPerson();
    }
}
