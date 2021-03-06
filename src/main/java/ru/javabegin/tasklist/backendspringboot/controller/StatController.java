package ru.javabegin.tasklist.backendspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.tasklist.backendspringboot.entity.Stat;
import ru.javabegin.tasklist.backendspringboot.service.StatService;

/**
 * Created by Termopsis on 13.08.2020.
 */

@RestController
@RequestMapping("/stat")
@CrossOrigin(origins = "http://localhost:4200")
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        System.out.println("StatController: create StatController -------------------------------------------------");
        this.statService = statService;
    }

    @GetMapping("/stat")
    public ResponseEntity<Stat> findById(){
        System.out.println("StatController: findById -------------------------------------------------");
        return ResponseEntity.ok(statService.findById());
    }
}
