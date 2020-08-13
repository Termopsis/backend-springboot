package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.tasklist.backendspringboot.entity.Stat;

/**
 * Created by Termopsis on 13.08.2020.
 */
@Repository
public interface StatRepository extends CrudRepository<Stat,Long> {



}
