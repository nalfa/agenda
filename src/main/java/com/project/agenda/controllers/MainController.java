package com.project.agenda.controllers;

import com.project.agenda.dtos.TaskDTO;
import com.project.agenda.dtos.ToDoListDTO;
import com.project.agenda.entities.Task;
import com.project.agenda.entities.ToDoList;
import com.project.agenda.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class MainController {

    @Autowired
    ToDoListService toDoListService;

    @GetMapping("/{id}")
    public Optional<ToDoList> getToDoList(@PathVariable Integer id) {

        return toDoListService.getToDoList(id);
    }

    @PostMapping
    public ToDoList createToDoList(@RequestBody ToDoListDTO toDoListDTO) {

        return toDoListService.createToDoList(toDoListDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoList(@PathVariable Integer id) {

        toDoListService.deleteToDoList(id);
    }

    @PostMapping("/{toDoListId}/tasks")
    public Task createTask(@PathVariable Integer toDoListId, @RequestBody TaskDTO newTask) {

        return toDoListService.createTask(toDoListId, newTask);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Integer id) {

        toDoListService.deleteTask(id);
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody TaskDTO updatedTask) {

        return toDoListService.updateTask(updatedTask);
    }
}