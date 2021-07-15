package com.termo.tasklist.backendspringboot.config;

import com.termo.tasklist.backendspringboot.entity.Stat;
import com.termo.tasklist.backendspringboot.repo.StatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatConfig {

    @Bean
    CommandLineRunner commandLineRunner(StatRepository statRepository){
        return args -> {
            Stat STAT = new Stat();
            statRepository.save(STAT);
        };

    }

}
