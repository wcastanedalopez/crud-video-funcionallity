package com.api.crud.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "registers")
public class Registration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany( mappedBy = "registration" )
    private List<Assignment> assignments;

    public Registration() {
    }

    public Registration(long id, List<Assignment> assignments) {
        this.id = id;
        this.assignments = assignments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
