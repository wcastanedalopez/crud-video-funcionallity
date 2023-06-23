package com.api.crud.controllers;

import com.api.crud.entities.Team;
import com.api.crud.services.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
@RepositoryRestResource(path = "teams", collectionResourceRel = "teams")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamServiceImpl teamServiceImpl;

    @GetMapping
    public List<Team> getRoutes(){
        return this.teamServiceImpl.getTeams();
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team){
        return this.teamServiceImpl.saveTeam(team);
    }

    @PostMapping(path = "/addList")
    public List<Team> saveByListTeams(@RequestBody List<Team> teams){
        return this.teamServiceImpl.saveTeams(teams);
    }

    @GetMapping (path = "/{id}")
    public Optional<Team> getRouteById(@PathVariable Long id) {
        return this.teamServiceImpl.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Team updateTeamById (@RequestBody Team team, Long id ) {
        return this.teamServiceImpl.updateById(team, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTeamById ( @PathVariable ("id") Long id) {
        boolean ok = this.teamServiceImpl.deleteById(id);

        if (ok ) {
            return "Team with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete team with this id";
        }
    }

    @DeleteMapping
    public String deleteTeams () {
        boolean ok = this.teamServiceImpl.deleteAll();

        if (ok ) {
            return "All teams were eliminated";
        } else {
            return "Error, we have a problem for delete teams with this id";
        }
    }



}
