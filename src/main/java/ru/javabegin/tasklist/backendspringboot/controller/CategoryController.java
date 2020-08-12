package ru.javabegin.tasklist.backendspringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.tasklist.backendspringboot.entity.Category;
import ru.javabegin.tasklist.backendspringboot.repo.CategoryRepository;

import java.util.List;

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
    public Category AddCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

}
