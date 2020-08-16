package ru.javabegin.tasklist.backendspringboot.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.tasklist.backendspringboot.entity.Category;
import ru.javabegin.tasklist.backendspringboot.repo.CategoryRepository;
import ru.javabegin.tasklist.backendspringboot.search.CategorySearchValues;

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
        System.out.println("categoryRepository: create CategoryController -------------------------------------------------");
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        System.out.println("categoryRepository: findAll -------------------------------------------------");

        return categoryRepository.findAllByOrderByTitleAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        System.out.println("categoryRepository: addCategory -------------------------------------------------");

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
        System.out.println("categoryRepository: update -------------------------------------------------");
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
        System.out.println("categoryRepository: findById -------------------------------------------------");
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
        System.out.println("categoryRepository: deleteById -------------------------------------------------");

        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("category with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues){
        System.out.println("categoryRepository: search -------------------------------------------------");
        return ResponseEntity.ok(categoryRepository.findByTitle(categorySearchValues.getText()));

    }


}
