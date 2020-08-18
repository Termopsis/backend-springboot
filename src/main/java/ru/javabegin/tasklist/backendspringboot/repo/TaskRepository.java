package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.javabegin.tasklist.backendspringboot.entity.Task;

/**
 * Created by Termopsis on 14.08.2020.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT c from Task c where " +
            "(:title is null or :title = '' or lower(c.title) like lower(concat('%', :title,'%'))) and "+
            "(:completed is null or c.completed=:completed) and "+
            "(:priorityId is null or c.priority.id=:priorityId) and "+
            "(:categoryId is null or c.category.id=:categoryId)")

//    Вывод всех данных
//    List<Task> findByParams(@Param("title") String title,
//                            @Param("completed") Integer completed,
//                            @Param("priorityId") Long priorityId,
//                            @Param("categoryId") Long categoryId);

    //Постраничность вывода данных поиска
    Page<Task> findByParams(@Param("title") String title,
                            @Param("completed") Integer completed,
                            @Param("priorityId") Long priorityId,
                            @Param("categoryId") Long categoryId,
                            Pageable pageable);


}
