package com.api.crud.controllers;

import com.api.crud.entities.User;
import com.api.crud.services.EmployedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employed")
@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
@CrossOrigin
public class EmployedController {

    @Autowired
    private EmployedServiceImpl employedServiceImpl;


    @GetMapping
    public List<User> getEmployees(){
        return this.employedServiceImpl.getEmployees();
    }

    @PostMapping( path = "/add")
    public User saveRoute(@RequestBody User user){
        return this.employedServiceImpl.saveEmployed(user);
    }

    @PostMapping(path = "/addList")
    public List<User> saveByListEmployeds(@RequestBody List<User> user){
        return this.employedServiceImpl.saveEmployees(user);
    }

    @GetMapping (path = "/{id}")
    public Optional<User> getEmployedById(@PathVariable Integer id) {
        return this.employedServiceImpl.getById(id);
    }

    @PostMapping(path = "/update/{id}")
    public User updateEmployedById (@RequestBody User user, Integer id ) {
        return this.employedServiceImpl.updateById(user, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmployedById ( @PathVariable ("id") Integer id) {
        boolean ok = this.employedServiceImpl.deleteById(id);

        if (ok ) {
            return "Employed with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete employed with this id";
        }
    }

    @DeleteMapping( path = "/delete")
    public String deleteEmployees () {
        boolean ok = this.employedServiceImpl.deleteAll();

        if (ok ) {
            return "All Employees were eliminated";
        } else {
            return "Error, we have a problem for delete employed";
        }
    }
}
