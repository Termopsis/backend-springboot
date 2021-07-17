package com.termo.tasklist.backendspringboot.service;

import com.termo.tasklist.backendspringboot.repo.StatRepository;
import org.springframework.stereotype.Service;
import com.termo.tasklist.backendspringboot.entity.Stat;

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
