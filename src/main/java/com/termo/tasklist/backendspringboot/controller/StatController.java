package com.termo.tasklist.backendspringboot.controller;

import com.termo.tasklist.backendspringboot.entity.Stat;
import com.termo.tasklist.backendspringboot.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Termopsis on 13.08.2020.
 */

@RestController
@RequestMapping("/stat")
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        System.out.println("StatController: create StatController -------------------------------------------------");
        this.statService = statService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Stat> findById(){
        System.out.println("StatController: findById -------------------------------------------------");
        return ResponseEntity.ok(statService.findById());
    }
}
