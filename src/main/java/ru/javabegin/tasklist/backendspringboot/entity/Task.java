package ru.javabegin.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Termopsis on 10.08.2020.
 */
@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
public class Task {
    private Long id;
    private String title;

    private Integer completed;
    private Date date;
    private Priority priority;
    private Category category;

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
    @Column(name = "completed")
    public Integer getCompleted() {
        return completed;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    public Priority getPriority() {
        return priority;
    }

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }
}
