package com.api.crud.entities;

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
    private List<User> userList;

    @OneToMany( mappedBy = "team" )
    private List<Assignment> assignments;

    public Team() {
    }

    public Team(Long id, String name, List<User> userList, List<Assignment> assignments) {
        this.id = id;
        this.name = name;
        this.userList = userList;
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

    public List<User> getEmployedList() {
        return userList;
    }

    public void setEmployedList(List<User> userList) {
        this.userList = userList;
    }
}
