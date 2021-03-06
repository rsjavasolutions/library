package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.java.library.exception.InvalidIdException;
import rs.java.library.model.Person;
import rs.java.library.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getById(Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        }
        throw new InvalidIdException("INVALID PERSON ID NUMBER");
    }

    public ResponseEntity<Person> updatePerson(Integer id, Person person) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            optionalPerson.get().setName(person.getName());
            optionalPerson.get().setSex(person.getSex());
            optionalPerson.get().setSurname(person.getSurname());
            personRepository.save(optionalPerson.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public ResponseEntity<Person> deleteById(Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.delete(optionalPerson.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}

