package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.javabegin.tasklist.backendspringboot.entity.Task;

import java.util.List;

/**
 * Created by Termopsis on 14.08.2020.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT c from Task c where " +
            "(:title is null or :title = '' or lower(c.title) like lower(concat('%', :title,'%'))) and "+
            "(:completed is null or c.completed=:completed) and "+
            "(:priorityId is null or c.priority.id=:priorityId) and "+
            "(:categoryId is null or c.category.id=:categoryId)")

    List<Task> findByParams(@Param("title") String title, @Param("completed") Integer completed, @Param("priorityId") Long priorityId, @Param("categoryId") Long categoryId);

}
