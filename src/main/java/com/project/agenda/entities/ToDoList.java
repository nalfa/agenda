package com.project.agenda.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToDoList {
    @Id
    @SequenceGenerator(name = "to_do_list_id_sequence", sequenceName = "to_do_list_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "to_do_list_id_sequence")
    private Integer id;
    private String name;
    @OneToMany(mappedBy="toDoList")
    private List<Task> tasks;

    public ToDoList(Integer id, String name, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public ToDoList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
