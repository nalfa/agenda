package com.project.agenda.repositories;

import com.project.agenda.entities.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Integer> {
}
