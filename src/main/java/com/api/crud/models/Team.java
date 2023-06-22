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

    @OneToMany( mappedBy = "team" )
    private List<Route> routes;

    @OneToMany( mappedBy = "team" )
    private List<Employed> employedList;

    public Team() {
    }

    public Team(Long id, String name, List<Route> routes, List<Employed> employedList) {
        this.id = id;
        this.name = name;
        this.routes = routes;
        this.employedList = employedList;
    }
    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
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
