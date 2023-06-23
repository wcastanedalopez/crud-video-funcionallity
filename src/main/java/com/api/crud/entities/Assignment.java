package com.api.crud.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany( mappedBy = "assignment" )
    private List<Route> routes;


    @ManyToOne()
    private Team team;

    @ManyToOne()
    private Registration registration;

    @Column
    private Date date;

    public Assignment() {
    }

    public Assignment(long id, List<Route> routes, Team team, Registration registration, Date date) {
        this.id = id;
        this.routes = routes;
        this.team = team;
        this.registration = registration;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
