package ru.javabegin.tasklist.backendspringboot.controller;

/**
 * Created by Termopsis on 14.08.2020.
 */

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.tasklist.backendspringboot.entity.Task;
import ru.javabegin.tasklist.backendspringboot.search.TaskSearchValues;
import ru.javabegin.tasklist.backendspringboot.service.TaskService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> findAll(){

        System.out.println("TaskController: findAll -------------------------------------------------");
        return taskService.findAll();

    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task){
        System.out.println("TaskController: AddPriority -------------------------------------------------");

        //Должен быть пустой null или 0
        if (task.getId() != null && task.getId() != 0) {
            return new ResponseEntity("redundant param: id must be null", HttpStatus.NOT_ACCEPTABLE);
        }

        //Не указано обязательное поле title
        if (task.getTitle() == null || task.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title",HttpStatus.NOT_ACCEPTABLE);
        }

        //Нужно проверять еще на дату
        //if task.getDate() ==

        return ResponseEntity.ok(taskService.save(task));

    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Task task){
        System.out.println("TaskController: update -------------------------------------------------");

        //Должен быть пустой null или 0
        if (task.getId() == null && task.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        //Не указано обязательное поле title
        if (task.getTitle() == null && task.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title",HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(taskService.save(task));

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id){
        System.out.println("TaskController: findById -------------------------------------------------");
        Task task = null;

        try {
            task = taskService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("not found element by id "+id, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(task);

    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        System.out.println("TaskController: deleteById -------------------------------------------------");

        try {
            taskService.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("task with id = "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PostMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskSearchValues taskSearchValues){
        System.out.println("TaskController: search -------------------------------------------------");

        String title = taskSearchValues.getTitle() != null ? taskSearchValues.getTitle() : null;

        Integer completed = taskSearchValues.getCompleted() != null ? taskSearchValues.getCompleted() : null;

        Long priority_id = taskSearchValues.getPriority_id() != null ? taskSearchValues.getPriority_id() : null;

        Long category_id = taskSearchValues.getCategory_id() != null ? taskSearchValues.getCategory_id() : null;

        String sortColumn = taskSearchValues.getSortColumn() != null ? taskSearchValues.getSortColumn() : null;
        String sortDirection = taskSearchValues.getSortDirection() != null ? taskSearchValues.getSortDirection() : null;

        Integer pageNumber = taskSearchValues.getPageNumber() != null ? taskSearchValues.getPageNumber() : null;
        Integer pageSize = taskSearchValues.getPageSize() != null ? taskSearchValues.getPageSize() : null;

        Sort.Direction direction = sortDirection == null || sortDirection.trim().length() == 0 || sortDirection.trim().equals("asc") ? Sort.Direction.ASC:Sort.Direction.DESC;

        Sort sort = Sort.by(direction,sortColumn);

        //Object page
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);

        Page result = taskService.search(title,completed,priority_id,category_id,pageRequest);


        return ResponseEntity.ok(result);
    }

}
