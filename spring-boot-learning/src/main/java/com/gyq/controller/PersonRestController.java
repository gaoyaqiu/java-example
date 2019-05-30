package com.gyq.controller;

import com.gyq.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyaqiu
 * @date 2019/5/30
 */
@RestController
public class PersonRestController {

    private final Person person;

    public PersonRestController(Person person) {
        this.person = person;
    }

    @GetMapping("/person")
    public Person person() {
        return person;
    }

}
