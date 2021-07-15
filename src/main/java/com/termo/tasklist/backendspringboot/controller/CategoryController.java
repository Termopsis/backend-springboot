package com.termo.tasklist.backendspringboot.controller;

import com.termo.tasklist.backendspringboot.service.CategoryService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.termo.tasklist.backendspringboot.entity.Category;
import com.termo.tasklist.backendspringboot.search.CategorySearchValues;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Termopsis on 11.08.2020.
 */
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        System.out.println("CategoryController: create CategoryController -------------------------------------------------");
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        System.out.println("categoryRepository: findAll -------------------------------------------------");
        return categoryService.findAllOrderedByTitleAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category){
        System.out.println("categoryRepository: addCategory -------------------------------------------------");

        if (category.getId() != null && category.getId() != 0){
            return new ResponseEntity("redundant param id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("miss param title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryService.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category){
        System.out.println("categoryRepository: update -------------------------------------------------");
        if (category.getId() == null && category.getId() == 0){
            return new ResponseEntity("miss param id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("miss param title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryService.save(category));
    }

    @GetMapping("find/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        System.out.println("categoryRepository: findById -------------------------------------------------");
        Category category = null;

        try {
            category = categoryService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("element with id = "+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id){
        System.out.println("categoryRepository: deleteById -------------------------------------------------");

        try {
            categoryService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("category with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues){
        System.out.println("categoryRepository: search -------------------------------------------------");
        return ResponseEntity.ok(categoryService.findByTitle(categorySearchValues.getTitle()));
    }
}
