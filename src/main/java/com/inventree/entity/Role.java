package com.inventree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name; // ROLE_ADMIN ou ROLE_FUNCIONARIO

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
