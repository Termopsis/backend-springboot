package ru.javabegin.tasklist.backendspringboot.service;

import org.springframework.stereotype.Service;
import ru.javabegin.tasklist.backendspringboot.entity.Priority;
import ru.javabegin.tasklist.backendspringboot.repo.PriorityRepository;

import java.util.List;

/**
 * Created by Termopsis on 16.08.2020.
 */
@Service
public class PriorityService {

    private final PriorityRepository repository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.repository = priorityRepository;
    }

    public List<Priority> findAll(){
        return repository.findAll();
    }

    public Priority save(Priority priority){
        return repository.save(priority);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Priority> findByTitle(String title){
        return repository.findByTitle(title);
    }

    public Priority findById(Long id){
        return repository.findById(id).get();
    }

    public List<Priority> findAllByOrderByIdAsc(){
        return repository.findAllByOrderByIdAsc();
    }

}
