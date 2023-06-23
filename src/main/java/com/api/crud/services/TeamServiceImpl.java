package com.api.crud.services;

import com.api.crud.entities.Team;
import com.api.crud.repositories.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl {

    @Autowired
    ITeamRepository teamRepository;

    public List<Team> getTeams () {
        List<Team> all = teamRepository.findAll();
        return all;
    }

    public List<Team> saveTeams (List<Team> listTeams) {
        List<Team> all = teamRepository.saveAll(listTeams);
        return all;
    }


    public Team saveTeam (Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> getById (Long id) {
        return teamRepository.findById(id);
    }

    public Team updateById (Team request, Long id) {
        Team aux = teamRepository.findById(id).get();
        aux.setName(request.getName());
        aux.setEmployedList(request.getEmployedList());
        aux.setAssignments(request.getAssignments());
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            teamRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            teamRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
