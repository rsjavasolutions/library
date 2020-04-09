package rs.java.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.java.library.model.Person;
import rs.java.library.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("people")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @PutMapping("people/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable Integer id, @RequestBody Person person){
        return personService.updatePerson(id,person);
    }

    @GetMapping("people")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @DeleteMapping("people/{id}")
    public ResponseEntity<Person> deleteById(@PathVariable Integer id){
        return personService.deleteById(id);
    }
}
