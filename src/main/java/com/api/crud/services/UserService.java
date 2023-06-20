package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers () {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser (UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getById (Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateById (UserModel request, Long id) {
        UserModel aux = userRepository.findById(id).get();
        aux.setEmail(request.getEmail());
        aux.setFirstName(request.getFirstName());
        aux.setLastName(request.getLastName());
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
}
