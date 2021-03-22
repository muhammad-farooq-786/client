package com.example.client.clientClass;

import com.example.client.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class demoClass {


    @GetMapping("/clientString")
    public ResponseEntity<String> getClientString() {
        final String url = "http://localhost:8081/personsString";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        return responseEntity;
    }

    @GetMapping("/clientObject")
    public Person getPerson(){


        final String url = "http://localhost:8081/personObject";

        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(url, Person.class);

        return person;

    }

    @GetMapping("/clientsList")
    public ResponseEntity<Person> getClients(){

        final String url = "http://localhost:8081/personsList";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> responseEntity = restTemplate.getForEntity(url, Person.class);

        return  responseEntity;
    }
}
