package com.simple.simple.controllers;

import com.simple.simple.enities.Person;
import com.simple.simple.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author michal.oles
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;


    /**
     * @return all people
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAll() {
        return personService.getAll();
    }

    /**
     * @param name name
     * @return search people
     */
    @RequestMapping(value = "/search/name/{name}", method = RequestMethod.GET)
    public List<Person> searchByName(@PathVariable String name) {
        return personService.searchByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add() {
        personService.add();
    }


}
