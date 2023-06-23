package com.api.crud.controllers;

import com.api.crud.entities.Employed;
import com.api.crud.entities.User;
import com.api.crud.services.EmployedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employed")
@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public class EmployedController {

    @Autowired
    private EmployedService employedService;


    @GetMapping
    public List<Employed> getEmployees(){
        return this.employedService.getEmployees();
    }

    @PostMapping( path = "/add")
    public Employed saveRoute(@RequestBody Employed employed){
        return this.employedService.saveEmployed(employed);
    }

    @PostMapping(path = "/addList")
    public List<Employed> saveByListEmployeds(@RequestBody List<Employed> employed){
        return this.employedService.saveEmployees(employed);
    }

    @GetMapping (path = "/{id}")
    public Optional<Employed> getEmployedById(@PathVariable Integer id) {
        return this.employedService.getById(id);
    }

    @PostMapping(path = "/update/{id}")
    public Employed updateEmployedById (@RequestBody Employed employed, Integer id ) {
        return this.employedService.updateById(employed, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmployedById ( @PathVariable ("id") Integer id) {
        boolean ok = this.employedService.deleteById(id);

        if (ok ) {
            return "Employed with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete employed with this id";
        }
    }

    @DeleteMapping( path = "/delete")
    public String deleteEmployees () {
        boolean ok = this.employedService.deleteAll();

        if (ok ) {
            return "All Employees were eliminated";
        } else {
            return "Error, we have a problem for delete employed";
        }
    }
}
