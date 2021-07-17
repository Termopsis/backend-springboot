package com.termo.tasklist.backendspringboot.config.data;

import com.termo.tasklist.backendspringboot.entity.security.Role;
import com.termo.tasklist.backendspringboot.entity.security.Status;
import com.termo.tasklist.backendspringboot.entity.security.User;
import com.termo.tasklist.backendspringboot.repo.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository){
        return args -> {
            User admin = new User(1L,
                    "admin@mail.com",
                    "Admin",
                    "Adminov",
                    "$2y$12$zDJYTtiU7opBeUhxqTEGK.8Rx6ps.enchumvk.tdzoBSP9/nKdL1.",
                    Role.ADMIN,
                    Status.ACTIVE);
            User user = new User(2L,
                    "user@mail.com",
                    "User",
                    "Userov",
                    "$2y$12$u2UzWMjed7wS3Qc4xtCumOwt3VZHMgTXLBondrFjrZVx8ign42nWC",
                    Role.USER,
                    Status.ACTIVE);
            userRepository.saveAll(List.of(admin,user));
        };
    }
}
