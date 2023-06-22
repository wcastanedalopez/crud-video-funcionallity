package com.api.crud.controllers;

import com.api.crud.models.Assignment;
import com.api.crud.models.Route;
import com.api.crud.services.AssignmentService;
import com.api.crud.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assignment")
@RepositoryRestResource(path = "assignments", collectionResourceRel = "assignments")
@CrossOrigin
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public List<Assignment> getAssignments(){
        return this.assignmentService.getAssignments();
    }

    @PostMapping
    public Assignment saveAssignment(@RequestBody Assignment assignment){
        return this.assignmentService.saveAssignment(assignment);
    }

    @PostMapping(path = "/addList")
    public List<Assignment> saveByListAssignments(@RequestBody List<Assignment> assignments){
        return this.assignmentService.saveAssignments(assignments);
    }

    @GetMapping (path = "/{id}")
    public Optional<Assignment> getRouteById(@PathVariable Long id) {
        return this.assignmentService.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Assignment updateAssignmentById (@RequestBody Assignment assignment, Long id ) {
        return this.assignmentService.updateById(assignment, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRouteById ( @PathVariable ("id") Long id) {
        boolean ok = this.assignmentService.deleteById(id);

        if (ok ) {
            return "Assignment with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete assignment with this id";
        }
    }

    @DeleteMapping
    public String deleteRoutes () {
        boolean ok = this.assignmentService.deleteAll();

        if (ok ) {
            return "All assignments were eliminated";
        } else {
            return "Error, we have a problem for delete assignments with this id";
        }
    }
}
