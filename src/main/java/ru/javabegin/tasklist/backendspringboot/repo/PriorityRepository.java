package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javabegin.tasklist.backendspringboot.entity.Priority;

import java.util.List;

/**
 * Created by Termopsis on 10.08.2020.
 */
@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

   @Query("SELECT p from Priority p where "+
           "(:title is null or :title ='' or lower(p.title) like lower(concat('%',:title,'%')))"+
           "order by p.title asc")
   List<Priority> findByTitle(@Param("title") String title);

   List<Priority> findAllByOrderByIdAsc();

}
