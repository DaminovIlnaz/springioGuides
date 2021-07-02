package ru.itis.restapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.restapp.model.Message;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MessageController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/message")
    public Message message(@RequestParam(value="name", required=false, defaultValue="World") String name){
        return new Message(counter.incrementAndGet(),
                String.format(template, name));
    }
}
