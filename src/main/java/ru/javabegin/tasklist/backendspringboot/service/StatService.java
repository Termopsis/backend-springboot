package ru.javabegin.tasklist.backendspringboot.service;

import org.springframework.stereotype.Service;
import ru.javabegin.tasklist.backendspringboot.entity.Stat;
import ru.javabegin.tasklist.backendspringboot.repo.StatRepository;

/**
 * Created by Termopsis on 16.08.2020.
 */
@Service
public class StatService {

    private final StatRepository repository;
    private final Long id = 1l;

    public StatService(StatRepository statRepository) {
        this.repository = statRepository;
    }

    public Stat findById(){
        return repository.findById(id).get();
    }

}
