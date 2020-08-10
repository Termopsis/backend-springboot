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
public class Priority {
    private Long id;
    private String title;
    private String color;
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
    @Column(name = "color")
    public String getColor() {
        return color;
    }

//    public void setColor(String color) {
//        this.color = color;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Priority priority = (Priority) o;
//        return Objects.equals(id, priority.id) &&
//                Objects.equals(title, priority.title) &&
//                Objects.equals(color, priority.color);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, color);
//    }

//    @OneToMany(mappedBy = "priorityByPriorityId")
//    public Collection<Task> getTasksById() {
//        return tasksById;
//    }

//    public void setTasksById(Collection<Task> tasksById) {
//        this.tasksById = tasksById;
//    }
}
