package ru.javabegin.tasklist.backendspringboot.service;

import org.springframework.stereotype.Service;
import ru.javabegin.tasklist.backendspringboot.entity.Category;
import ru.javabegin.tasklist.backendspringboot.repo.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Termopsis on 16.08.2020.
 */

@Service
@Transactional
public class CategoryService {

    // TODO categoryService
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Category> findByTitle(String title){
        return repository.findByTitle(title);
    }

    public Category findById(Long id){
        return repository.findById(id).get();
    }

    public List<Category> findAllOrderedByTitleAsc(){
        return repository.findAllByOrderByTitleAsc();
    }
}
