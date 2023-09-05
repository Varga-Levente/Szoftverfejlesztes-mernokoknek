package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Demo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class DemoController {

    private Map<String, Demo> demoList = new HashMap<>(){{
       put("0", new Demo("1", "John Doe", "25", "Budapest", "1995-01-01"));
       put("1", new Demo("2", "Jane Doe", "23", "Debrecen", "1997-01-01"));
       put("2", new Demo("3", "Jack Doe", "21", "Szeged", "1999-01-01"));
    }};

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/people")
    public String getPeople(){
        String people = "";
        for (Demo demo : demoList.values()) {
            people += demo.toString();
        }
        return people;
    }

    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable int id){
        //If id is out of bounds, throw 404
        if(id < 0 || id >= demoList.size()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
        return demoList.get(id).toString();
    }

    @PostMapping("/person")
    public String addPerson(@RequestBody Demo demo){
        demoList.put(UUID.randomUUID().toString(), demo);
        return demo.toString();
    }

}
