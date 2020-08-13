package ru.javabegin.tasklist.backendspringboot.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.tasklist.backendspringboot.entity.Priority;
import ru.javabegin.tasklist.backendspringboot.entity.Priority;
import ru.javabegin.tasklist.backendspringboot.repo.PriorityRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Termopsis on 10.08.2020.
 */
@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/all")
    public List<Priority> findAll(){
        return priorityRepository.findAllByOrderByIdAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> AddPriority(@RequestBody Priority priority){

        if(priority.getId() != null && priority.getId() !=0){
            return new ResponseEntity("Redundant  param: Id must be null", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("miss param color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Priority priority){

        if (priority.getId() == null && priority.getId() == 0){
            return new ResponseEntity("miss param id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("miss param title", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("miss param color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id){

        Priority priority = null;

        try {
            priority = priorityRepository.findById(id).get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id = "+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priority);
    }
    
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Priority> deleteById(@PathVariable Long id){

        Priority priority = null;

        try {
            priorityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("priority with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity("delete is successful",HttpStatus.OK);

    }
    
}
