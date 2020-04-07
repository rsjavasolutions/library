package rs.java.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.java.library.exception.InvalidIdException;
import rs.java.library.model.Person;
import rs.java.library.repository.PersonRepository;

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

    public Person getById(Integer id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()){
            return optionalPerson.get();
        }
        throw new InvalidIdException("INVALID PERSON ID NUMBER");
    }
}
