package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.tasklist.backendspringboot.entity.Category;
import ru.javabegin.tasklist.backendspringboot.entity.Priority;

import java.util.List;

/**
 * Created by Termopsis on 10.08.2020.
 */
@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

   List<Priority> findAllByOrderByIdAsc();

}
