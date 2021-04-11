package com.example.client.clientClass;

import com.example.client.model.Person;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class demoClass {



    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person){
        final String url = "http://localhost:8081/addPerson";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Person> httpEntity = new HttpEntity<>(person, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url,httpEntity,Person.class);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updatePerson")
    public ResponseEntity updatePerson(@RequestBody Person person) {
        final String url = "http://localhost:8081/updatePerson";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Person> httpEntity = new HttpEntity<>(person, headers);

        restTemplate.put(url,person);
        //restTemplate.postForObject(url, httpEntity, Person.class);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllPersons")
    public ResponseEntity<List<Person>> getAllPersons(){

        final String url = "http://localhost:8081/getAllPersons";

        RestTemplate restTemplate = new RestTemplate();
        List<Person> personList = Arrays.asList(restTemplate.getForObject(url, Person[].class));

        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }

//    @GetMapping("getPersonByName/{name}")
//    public ResponseEntity<Person> getPersonByName(@PathVariable String name){
//
//
//        final String url = "http://localhost:8081/getPersonByName/{name}";
//
//        RestTemplate restTemplate = new RestTemplate();
//        Person person = restTemplate.getForObject(url, Person.class);
//
//        return new ResponseEntity<Person>(person, HttpStatus.OK);
//
//    }

    @GetMapping("getPersonByName/{name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String name){


        final String url = "http://localhost:8081/getPersonByName/{name}";

        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(url, Person.class, new String[]{name});

        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @GetMapping("getPersonById/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {

        final String url = "http://localhost:8081/getPersonById/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(url, Person.class,new String[]{id});
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @DeleteMapping("deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable String id){
        final String url = "http://localhost:8081/deletePerson/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url,new String[]{id});
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
