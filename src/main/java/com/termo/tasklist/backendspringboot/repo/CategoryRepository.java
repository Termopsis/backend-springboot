package com.termo.tasklist.backendspringboot.repo;

import com.termo.tasklist.backendspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Termopsis on 11.08.2020.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    //Ищет по методу "содержит"
    @Query("SELECT c from Category c where " +
            "(:title is null or :title = '' or lower(c.title) like lower(concat('%', :title,'%'))) "+
            "order by c.title asc")
    List<Category> findByTitle(@Param("title") String title);

    List<Category> findAllByOrderByTitleAsc(); // Получение всех значений отсортированных по title

}
