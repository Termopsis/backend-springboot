package ru.javabegin.tasklist.backendspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.tasklist.backendspringboot.entity.Stat;
import ru.javabegin.tasklist.backendspringboot.repo.StatRepository;

/**
 * Created by Termopsis on 13.08.2020.
 */

@RestController
//@RequestMapping("/stat")
public class StatController {

    private final StatRepository statRepository;
    private final Long id = 1l;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @GetMapping("/stat")
    public ResponseEntity<Stat> findById(){
        return ResponseEntity.ok(statRepository.findById(id).get());
    }

}
