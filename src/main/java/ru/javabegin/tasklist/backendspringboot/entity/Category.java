package ru.javabegin.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Termopsis on 10.08.2020.
 */
@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
public class Category {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
    private Collection<Task> tasksById;

    //Аннотация уазывает что поле будет заполняться БД.
    //Т.к. в бд autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    @Basic
    @Column(name = "completed_count")
    public Long getCompletedCount() {
        return completedCount;
    }

//    public void setCompletedCount(Long completedCount) {
//        this.completedCount = completedCount;
//    }

    @Basic
    @Column(name = "uncompleted_count")
    public Long getUncompletedCount() {
        return uncompletedCount;
    }

//    public void setUncompletedCount(Long uncompletedCount) {
//        this.uncompletedCount = uncompletedCount;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Category category = (Category) o;
//        return Objects.equals(id, category.id) &&
//                Objects.equals(title, category.title) &&
//                Objects.equals(completedCount, category.completedCount) &&
//                Objects.equals(uncompletedCount, category.uncompletedCount);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, completedCount, uncompletedCount);
//    }

//    @OneToMany(mappedBy = "categoryByCategoryId")
//    public Collection<Task> getTasksById() {
//        return tasksById;
//    }

//    public void setTasksById(Collection<Task> tasksById) {
//        this.tasksById = tasksById;
//    }
}
