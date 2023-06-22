package com.api.crud.services;

import com.api.crud.models.Route;
import com.api.crud.repositories.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    IRouteRepository userRepository;

    public List<Route> getRoutes () {
        List<Route> all = userRepository.findAll();
        return all;
    }

    public List<Route> saveRoutes (List<Route> listRoutes) {
        List<Route> all = userRepository.saveAll(listRoutes);
        return all;
    }


    public Route saveRoute (Route route) {
        return userRepository.save(route);
    }

    public Optional<Route> getById (Long id) {
        return userRepository.findById(id);
    }

    public Route updateById (Route request, Long id) {
        Route aux = userRepository.findById(id).get();
        aux.setName(request.getName());
        aux.setSector(request.getSector());
        aux.setSede(request.getSede());
        userRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Long id) {
         try {
             userRepository.deleteById(id);
             return true;
         }catch (Exception e) {
             return false;
         }
    }
    public Boolean deleteAll () {
        try {
            userRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
