package com.api.crud.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

//    @OneToMany( mappedBy = "team" )
//    private List<Route> routes;

    @OneToMany( mappedBy = "team" )
    private List<Employed> employedList;

    @OneToMany( mappedBy = "team" )
    private List<Assignment> assignments;

    public Team() {
    }

    public Team(Long id, String name, List<Employed> employedList, List<Assignment> assignments) {
        this.id = id;
        this.name = name;
        this.employedList = employedList;
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employed> getEmployedList() {
        return employedList;
    }

    public void setEmployedList(List<Employed> employedList) {
        this.employedList = employedList;
    }
}
