package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;



    @Column
    private String name;

    @Column
    private String sector;

    @Column
    private String sede;

    @Column
    private String team;

    public Route(Long id, String name, String sector, String sede, String team) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.sede = sede;
        this.team = team;
    }

    public Route() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
