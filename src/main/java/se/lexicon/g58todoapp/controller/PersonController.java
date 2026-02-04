package se.lexicon.g58todoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g58todoapp.dto.PersonDto;
import se.lexicon.g58todoapp.entity.Person;
import se.lexicon.g58todoapp.repo.PersonRepository;
import se.lexicon.g58todoapp.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

//localhost:8080/api/people for all the endpoint in this class.
@RequestMapping("/api/people")
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    //RequestParam = ?name=Simon
    //GET localhost:8080/api/hello?name=Simon
    @RequestMapping(value = "/hello")
    public String hello (@RequestParam(defaultValue = "from PersonController!") String name) {
        return "Hello, " + name;
    }

    //GET localhost:8080/api/people
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getPersons() {

        return personService.findAll();
    }

    //PathVariable = {id}
    //GET localhost:8080/api/people/1
    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable Long id){
        return personService.findById(id);
    }

    //POST localhost:8080/api/people
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPerson(@RequestBody Person person){
        personService.createPerson(person);
    }

    //DELETE Localhost:8080/api/people/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
    }





}
