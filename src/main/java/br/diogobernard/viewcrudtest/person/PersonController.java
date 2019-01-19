package br.diogobernard.viewcrudtest.person;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/person")
public class PersonController {

    private static final List<Person> bd = new ArrayList<Person>();

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPeople() {
        return bd;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonByName(@PathVariable("id") Integer id) {
        return bd.stream()
                .filter(s -> id == s.getId())
                .findFirst()
                .get();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object registerPerson(@RequestBody Person person) {
        bd.add(person);
        return new ResponseEntity<>("Successful registration", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removePerson(@PathVariable("id") Integer id) {
        bd.removeIf(s -> id == s.getId());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable("id") Integer id, @RequestBody Person person) {
        Person p = bd.stream()
                .filter(s -> id == s.getId())
                .findFirst().get();
        p.setAge(person.getAge());
        p.setName(person.getName());
    }
}
