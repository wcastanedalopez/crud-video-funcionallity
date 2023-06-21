package com.api.crud.controllers;

import com.api.crud.models.Route;
import com.api.crud.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/route")
@RepositoryRestResource(path = "routes", collectionResourceRel = "routes")
@CrossOrigin
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getRoutes(){
        return this.routeService.getRoutes();
    }

    @PostMapping
    public Route saveRoute(@RequestBody Route route){
        return this.routeService.saveRoute(route);
    }

    @PostMapping(path = "/addList")
    public List<Route> saveByListRoutes(@RequestBody List<Route> routes){
        return this.routeService.saveRoutes(routes);
    }

    @GetMapping (path = "/{id}")
    public Optional<Route> getRouteById(@PathVariable Long id) {
        return this.routeService.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Route updateRouteById (@RequestBody Route user, Long id ) {
         return this.routeService.updateById(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRouteById ( @PathVariable ("id") Long id) {
        boolean ok = this.routeService.deleteById(id);

        if (ok ) {
            return "Route with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete route with this id";
        }
    }

    @DeleteMapping
    public String deleteRoutes () {
        boolean ok = this.routeService.deleteAll();

        if (ok ) {
            return "All routes were eliminated";
        } else {
            return "Error, we have a problem for delete route with this id";
        }
    }





}
