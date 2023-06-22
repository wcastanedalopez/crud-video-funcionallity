package com.api.crud.services;

import com.api.crud.models.Employed;
import com.api.crud.models.Route;
import com.api.crud.repositories.IEmployedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployedService {

    @Autowired
    IEmployedRepository employedRepository;

    public List<Employed> getEmployees () {
        List<Employed> all = employedRepository.findAll();
        return all;
    }

    public List<Employed> saveEmployees(List<Employed> listEmployees) {
        List<Employed> all = employedRepository.saveAll(listEmployees);
        return all;
    }


    public Employed saveEmployed (Employed employed) {
        return employedRepository.save(employed);
    }

    public Optional<Employed> getById (Integer id) {
        return employedRepository.findById(id);
    }

    public Employed updateById (Employed request, Integer id) {
        Employed aux = employedRepository.findById(id).get();
        aux.setName(request.getName());
        aux.setPassword(request.getPassword());
        aux.setEmail(request.getEmail());
        aux.setRoles(request.getRoles());
        aux.setUsername(request.getUsername());
        aux.setLastName(request.getLastName());
        aux.setCc(request.getCc());
        employedRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Integer id) {
        try {
            employedRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            employedRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
