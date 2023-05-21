package com.project.agenda.entities;

import jakarta.persistence.*;

@Entity
public class ToDoList {
    @Id
    @SequenceGenerator(name = "to_do_list_id_sequence", sequenceName = "to_do_list_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "to_do_list_id_sequence")
    private Integer id;
    private String name;

    public ToDoList(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
