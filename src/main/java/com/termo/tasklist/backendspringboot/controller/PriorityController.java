package com.termo.tasklist.backendspringboot.controller;

import com.termo.tasklist.backendspringboot.entity.Priority;
import com.termo.tasklist.backendspringboot.search.PrioritySearchValues;
import com.termo.tasklist.backendspringboot.service.PriorityService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Termopsis on 10.08.2020.
 */
@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        System.out.println("PriorityController: create PriorityController -------------------------------------------------");
        this.priorityService = priorityService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('user:read')")
    public List<Priority> findAll(){
        System.out.println("PriorityController: findAll -------------------------------------------------");
        return priorityService.findAllByOrderByIdAsc();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<Priority> add(@RequestBody Priority priority){
        System.out.println("PriorityController: AddPriority -------------------------------------------------");
        if(priority.getId() != null && priority.getId() !=0){
            return new ResponseEntity("Redundant  param: Id must be null", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("miss param color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityService.save(priority));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity update(@RequestBody Priority priority){
        System.out.println("PriorityController: update -------------------------------------------------");
        if (priority.getId() == null && priority.getId() == 0){
            return new ResponseEntity("miss param id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("miss param title", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("miss param color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityService.save(priority));
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Priority> findById(@PathVariable Long id){
        System.out.println("PriorityController: findById -------------------------------------------------");
        Priority priority = null;

        try {
            priority = priorityService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id = "+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priority);
    }
    
    @DeleteMapping("/delete/id/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<Priority> deleteById(@PathVariable Long id){
        System.out.println("PriorityController: deleteById -------------------------------------------------");

        try {
            priorityService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("priority with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues){
        System.out.println("PriorityController: search -------------------------------------------------");
        return ResponseEntity.ok(priorityService.findByTitle(prioritySearchValues.getTitle()));
    }
}
