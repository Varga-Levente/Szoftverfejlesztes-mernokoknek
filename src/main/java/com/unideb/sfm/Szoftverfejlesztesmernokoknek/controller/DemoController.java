package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Demo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;
import java.util.*;
import java.util.Date;

@RestController
public class DemoController {

    private Map<String, Demo> demoList = new HashMap<>(){{
       put("0", new Demo("John Doe", 25, "Budapest", new Date(1998, 01,01)));
       put("1", new Demo("John Adams", 11, "Debrecen", new Date(1999, 06,02)));
       put("2", new Demo("John Valaki", 38, "Szeged", new Date(2000, 12,11)));
    }};

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/people")
    public String getPeople(){
        //Create an empty string and add every HashMap key-value pair to it
        //[Key: Value]<br>
        String people = "";
        for(Map.Entry<String, Demo> entry : demoList.entrySet()){
            people += entry.getKey() + ": " + entry.getValue();
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

    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable String id){
        if(!demoList.containsKey(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
        demoList.remove(id);
        return "Person deleted";
    }

    @GetMapping("/DB")
    public String getDB() throws SQLException {
        //For testing only
        String jbdcUrl = "jdbc:h2:file:./DB";
        Connection conn = DriverManager.getConnection(jbdcUrl, "sa", "password");
        String sql = "SELECT * FROM USERS";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String result = "";
        // List all users [NAME, AGE, BIRTHPLACE, BIRTHDAY]
        while(rs.next()){
            result += rs.getString("NAME") + ", " + rs.getInt("AGE") + ", " + rs.getString("BIRTHPLACE") + ", " + rs.getDate("BIRTHDAY") + "<br>";
        }
        return result;
    }

}
