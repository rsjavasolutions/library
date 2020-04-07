package rs.java.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.java.library.model.Person;
import rs.java.library.service.PersonService;

@RestController
@RequestMapping("/api/")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
