package com.example.springboot.InitDB;

import com.example.springboot.model.Person;
import com.example.springboot.service.PersonService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitDB implements ApplicationListener<ApplicationReadyEvent> {
    PersonService personService;

    public InitDB(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Application ready");

        //Create person objet
        Person person1 = new Person("Jane", "Doe", 12);
        Person person2 = new Person("Gallo", "Niang", 22);

        //Insert into the database
        personService.createAll(List.of(person1,person2));
        //Afficher
        System.out.println("Personnes : "+ personService.getAllPerson());
    }
}
