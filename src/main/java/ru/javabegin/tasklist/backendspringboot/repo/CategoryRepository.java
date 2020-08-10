package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabegin.tasklist.backendspringboot.entity.Category;

/**
 * Created by Termopsis on 11.08.2020.
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {


}
