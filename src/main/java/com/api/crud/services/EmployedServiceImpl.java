package com.api.crud.services;

import com.api.crud.entities.User;
import com.api.crud.repositories.IEmployedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployedServiceImpl {

    @Autowired
    IEmployedRepository employedRepository;

    public List<User> getEmployees () {
        List<User> all = employedRepository.findAll();
        return all;
    }

    public List<User> saveEmployees(List<User> listEmployees) {
        List<User> all = employedRepository.saveAll(listEmployees);
        return all;
    }


    public User saveEmployed (User user) {
        return employedRepository.save(user);
    }

    public Optional<User> getById (Integer id) {
        return employedRepository.findById(id);
    }

    public User updateById (User request, Integer id) {
        User aux = employedRepository.findById(id).get();
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
