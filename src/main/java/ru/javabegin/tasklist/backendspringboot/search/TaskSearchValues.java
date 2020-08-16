package ru.javabegin.tasklist.backendspringboot.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Termopsis on 15.08.2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskSearchValues {

    private String title;
    private Integer completed;

    private Long priority_id;
    private Long category_id;

}
