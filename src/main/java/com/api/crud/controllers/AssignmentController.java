package com.api.crud.controllers;

import com.api.crud.entities.Assignment;
import com.api.crud.services.AssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignment")
@RepositoryRestResource(path = "assignments", collectionResourceRel = "assignments")
@CrossOrigin
public class AssignmentController {
    @Autowired
    private AssignmentServiceImpl assignmentServiceImpl;

    @GetMapping
    public List<Assignment> getAssignments(){
        return this.assignmentServiceImpl.getAssignments();
    }

    @PostMapping
    public Assignment saveAssignment(@RequestBody Assignment assignment){
        return this.assignmentServiceImpl.saveAssignment(assignment);
    }

    @PostMapping(path = "/addList")
    public List<Assignment> saveByListAssignments(@RequestBody List<Assignment> assignments){
        return this.assignmentServiceImpl.saveAssignments(assignments);
    }

    @GetMapping (path = "/{id}")
    public Optional<Assignment> getRouteById(@PathVariable Long id) {
        return this.assignmentServiceImpl.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Assignment updateAssignmentById (@RequestBody Assignment assignment, Long id ) {
        return this.assignmentServiceImpl.updateById(assignment, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRouteById ( @PathVariable ("id") Long id) {
        boolean ok = this.assignmentServiceImpl.deleteById(id);

        if (ok ) {
            return "Assignment with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete assignment with this id";
        }
    }

    @DeleteMapping
    public String deleteRoutes () {
        boolean ok = this.assignmentServiceImpl.deleteAll();

        if (ok ) {
            return "All assignments were eliminated";
        } else {
            return "Error, we have a problem for delete assignments with this id";
        }
    }
}
