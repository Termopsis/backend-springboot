package com.termo.tasklist.backendspringboot.service;

import com.termo.tasklist.backendspringboot.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.termo.tasklist.backendspringboot.repo.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Termopsis on 16.08.2020.
 */
@Service
@Transactional
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

    public Page<Task> search(String text, Integer completed, Long priorityId, Long categoryId, PageRequest pageRequest){
        return repository.findByParams(text,completed,priorityId,categoryId, pageRequest);
    }

}
