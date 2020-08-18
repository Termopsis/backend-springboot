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
    //private Long priorityId;
    //private Long categoryId;
    private Priority priority;
    private Category category;

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
    @Column(name = "completed")
    public Integer getCompleted() {
        return completed;
    }

//    public void setCompleted(Integer completed) {
//        this.completed = completed;
//    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

//    public void setDate(Timestamp date) {
//        this.date = date;
//    }

//    public void setPriorityId(Long priorityId) {
//        this.priorityId = priorityId;
//    }

//    public void setCategoryId(Long categoryId) {
//        this.categoryId = categoryId;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task task = (Task) o;
//        return Objects.equals(id, task.id) &&
//                Objects.equals(title, task.title) &&
//                Objects.equals(completed, task.completed) &&
//                Objects.equals(date, task.date) &&
//                Objects.equals(priorityId, task.priorityId) &&
//                Objects.equals(categoryId, task.categoryId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, completed, date, priorityId, categoryId);
//    }


    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    public Priority getPriority() {
        return priority;
    }

//    public void setPriorityByPriorityId(Priority priorityByPriorityId) {
//        this.priorityByPriorityId = priorityByPriorityId;
//    }

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }

//    public void setCategoryByCategoryId(Category categoryByCategoryId) {
//        this.categoryByCategoryId = categoryByCategoryId;
//    }
}
