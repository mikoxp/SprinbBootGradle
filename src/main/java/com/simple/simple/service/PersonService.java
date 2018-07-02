package com.simple.simple.service;

import com.simple.simple.enities.Person;
import com.simple.simple.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll() {
        List<Person> result = new LinkedList<>();
        Iterable<Person> all = personRepository.findAll();
        all.forEach(result::add);
        return result;
    }

    public List<Person> searchByName(String name) {
        String nameToQuery = "%" + name + "%";
        return personRepository.findByNameLike(nameToQuery);
    }

    public void add() {
        Person person = new Person();
        person.setName("Test");
        person.setSurname("Test");
        personRepository.save(person);
    }
}
