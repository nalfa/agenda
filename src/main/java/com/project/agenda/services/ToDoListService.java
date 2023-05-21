package com.project.agenda.services;

import com.project.agenda.dtos.ToDoListDTO;
import com.project.agenda.entities.ToDoList;
import com.project.agenda.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

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
}
