package com.api.crud.services;

import com.api.crud.entities.Assignment;
import com.api.crud.repository.IAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl {

    @Autowired
    IAssignmentRepository assignmentRepository;

    public List<Assignment> getAssignments () {
        List<Assignment> all = assignmentRepository.findAll();
        return all;
    }

    public List<Assignment> saveAssignments(List<Assignment> listAssignments) {
        List<Assignment> all = assignmentRepository.saveAll(listAssignments);
        return all;
    }


    public Assignment saveAssignment (Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getById (Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment updateById (Assignment request, Long id) {
        Assignment aux = assignmentRepository.findById(id).get();
        aux.setDate(request.getDate());
        aux.setTeam(request.getTeam());
        aux.setRegistration(request.getRegistration());
        aux.setRoutes(request.getRoutes());
        assignmentRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            assignmentRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            assignmentRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
