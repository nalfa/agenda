package com.project.agenda.services;

import com.project.agenda.dtos.TaskDTO;
import com.project.agenda.dtos.ToDoListDTO;
import com.project.agenda.entities.Task;
import com.project.agenda.entities.ToDoList;
import com.project.agenda.repositories.TaskRepository;
import com.project.agenda.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    TaskRepository taskRepository;

    public Optional<ToDoList> getToDoList(Integer id) {

        return toDoListRepository.findById(id);
    }

    public ToDoList createToDoList(ToDoListDTO toDoListDTO) {

        ToDoList toDoList = new ToDoList();
        toDoList.setName(toDoListDTO.getName());

        return toDoListRepository.save(toDoList);
    }

    public void deleteToDoList(Integer id) {

        toDoListRepository.deleteById(id);
    }

    public Task createTask(Integer toDoListId, TaskDTO newTask) {

        Task task = new Task();
        ToDoList toDoList = toDoListRepository.findById(toDoListId).get();

        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setToDoList(toDoList);

        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {

        taskRepository.deleteById(id);
    }

    public Task updateTask(TaskDTO updatedTask) {

        Task task = taskRepository.findById(updatedTask.getId()).get();

        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
        task.setDone(updatedTask.getDone());

        return taskRepository.save(task);
    }
}