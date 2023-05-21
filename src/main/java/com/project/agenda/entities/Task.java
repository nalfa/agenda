package com.project.agenda.entities;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @SequenceGenerator(name = "task_id_sequence", sequenceName = "task_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    private Integer id;
    private String name;
    private String description;
    private Boolean done;
    @ManyToOne
    @JoinColumn(name="to_do_list_id", nullable=false)
    private ToDoList toDoList;

    public Task() {

    }

    public Task(Integer id, String name, String description, Boolean done, ToDoList toDoList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
        this.toDoList = toDoList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
}
