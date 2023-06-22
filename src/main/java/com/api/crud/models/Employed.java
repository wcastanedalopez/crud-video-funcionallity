package com.api.crud.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "employees")
public class Employed {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    private Integer cc;

    @Column
    private String username;

    @Column
    private String password;
    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @ManyToOne()
    private Team team;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYED_ROLES",
            joinColumns = {
                    @JoinColumn(name = "EMPLOYED_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    public Employed() {
    }

    public Employed(Integer cc, String username, String password, String name, String lastName, String email, Team team, Set<Role> roles) {
        this.cc = cc;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.team = team;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}