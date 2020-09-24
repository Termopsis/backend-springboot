package ru.javabegin.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "completed_count", updatable = false)
    private Long completedCount;

    @Column(name = "uncompleted_count", updatable = false)
    private Long uncompletedCount;

    //Аннотация уазывает что поле будет заполняться БД.
    //Т.к. в бд autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "completed_count", updatable = false)
    public Long getCompletedCount() {
        return completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count", updatable = false)
    public Long getUncompletedCount() {
        return uncompletedCount;
    }

}
