package com.security.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    List<String> myList = new ArrayList<>();


        MyController(){
            myList.add("first");
            myList.add("1");
            myList.add("10");
            myList.add("new");
        }

    @GetMapping("/my-endpoint")
    public String myEndpoint(@RequestHeader("X-Requested-With") String requestedWith) {
        // Обробка запиту
        return "Response";
    }

    @GetMapping("/")
    public List<String> listString() {
        return myList;
    }

    @PostMapping("/create")
    public String create(String req) {
        myList.add(req);
        return req;
    }

}