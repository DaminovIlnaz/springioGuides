package ru.itis.restapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.restapp.model.Page;


@RestController
public class PageController {

    @RequestMapping("/page")
    public Page[] getPage(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Page[]> response =
                restTemplate.getForEntity(
                        "https://jsonplaceholder.typicode.com/photos",
                        Page[].class);
        Page[] employees = response.getBody();
        return employees;
    }
}
