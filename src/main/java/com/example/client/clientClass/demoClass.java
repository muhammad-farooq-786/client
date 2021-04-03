package com.example.client.clientClass;

import com.example.client.model.Person;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class demoClass {


    @GetMapping("/personsString")
    public ResponseEntity<String> getClientString() {
        final String url = "http://localhost:8081/personsString";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        return responseEntity;
    }

    @GetMapping("/personObject")
    public Person getPerson(){


        final String url = "http://localhost:8081/personObject";

        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(url, Person.class);

        return person;

    }



    @GetMapping("/personsList")
    public ResponseEntity<List<Person>> getProfiles() {

        final String url = "http://localhost:8081/personsList";
        RestTemplate restTemplate = new RestTemplate();
        List<Person> personList = Arrays.asList(restTemplate.getForObject(url, Person[].class));
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }

    //@GetMapping("/personsList")
//    public ResponseEntity<Person[]> getClients(){
//
//        final String url = "http://localhost:8081/personsList";
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Person>> responseEntity = restTemplate.getForEntity(url, Person.class[]);
//
//        return  responseEntity;
//    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") int id){
        int params = id;
        final String url = "http://localhost:8081/person/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(url, Person.class,params);

        return person;
    }

    @PostMapping("/insertPersonURL/{id}/{name}")
    public void insertPersonURL(@PathVariable int id,@PathVariable String name){
        final String url = "http://localhost:8081/insertPersonURL/{id}/{name}";
        Person person = new Person(id,name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Person> httpEntity = new HttpEntity<>(person, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url,httpEntity,Person.class,person.getId(),person.getName());
    }

    @PostMapping("/insertPerson")
    public void insertPerson(@RequestBody Person person) throws JSONException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
        HttpEntity<Person> httpEntity = new HttpEntity<>(person, headers);

        final String url = "http://localhost:8081/insertPerson";
        restTemplate.postForObject(url, httpEntity, Person.class);
    }

}
