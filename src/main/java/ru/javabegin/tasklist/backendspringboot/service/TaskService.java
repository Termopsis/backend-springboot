package ru.javabegin.tasklist.backendspringboot.service;

import org.springframework.stereotype.Service;
import ru.javabegin.tasklist.backendspringboot.entity.Task;
import ru.javabegin.tasklist.backendspringboot.repo.TaskRepository;

import java.util.List;

/**
 * Created by Termopsis on 16.08.2020.
 */
@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    public List<Task> findAll(){return repository.findAll();}

    public Task save(Task task){
        return repository.save(task);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Task findById(Long id){
        return repository.findById(id).get();
    }

    public List<Task> search(String text, Integer completed, Long priorityId, Long categoryId){
        return repository.findByParams(text,completed,priorityId,categoryId);
    }

}
