package ru.javabegin.tasklist.backendspringboot.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.tasklist.backendspringboot.entity.Category;
import ru.javabegin.tasklist.backendspringboot.entity.Priority;
import ru.javabegin.tasklist.backendspringboot.repo.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Termopsis on 11.08.2020.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/testCategory")
    public List<Category> testCategory(){

        List<Category> list = categoryRepository.findAll();
        return list;

    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){

        if (category.getId() != null && category.getId() != 0){
            return new ResponseEntity("redundant param id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("miss param title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category){

        if (category.getId() == null && category.getId() == 0){
            return new ResponseEntity("miss param id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("miss param title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @GetMapping("find/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){

        Category category = null;

        try {
            category = categoryRepository.findById(id).get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("element with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(category);

    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id){

        Category category = null;

        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("category with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

}
