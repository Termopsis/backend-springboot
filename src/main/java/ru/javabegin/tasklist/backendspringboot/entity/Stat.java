package ru.javabegin.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Termopsis on 10.08.2020.
 */
@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
public class Stat {
    private Long id;
    private Long completedTotal;
    private Long uncompletedTotal;

    //Только одна запись - новый создаваться не будет
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    @Basic
    @Column(name = "completed_total")
    public Long getCompletedTotal() {
        return completedTotal;
    }

//    public void setCompletedTotal(Long completedTotal) {
//        this.completedTotal = completedTotal;
//    }

    @Basic
    @Column(name = "uncompleted_total")
    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }

//    public void setUncompletedTotal(Long uncompletedTotal) {
//        this.uncompletedTotal = uncompletedTotal;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Stat stat = (Stat) o;
//        return Objects.equals(id, stat.id) &&
//                Objects.equals(completedTotal, stat.completedTotal) &&
//                Objects.equals(uncompletedTotal, stat.uncompletedTotal);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, completedTotal, uncompletedTotal);
//    }
}
