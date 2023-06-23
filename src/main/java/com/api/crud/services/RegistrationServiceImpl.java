package com.api.crud.services;

import com.api.crud.entities.Registration;
import com.api.crud.repositories.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RegistrationServiceImpl {

    @Autowired
    IRegistrationRepository registrationRepository;

    public List<Registration> getRegisters () {
        List<Registration> all = registrationRepository.findAll();
        return all;
    }

    public List<Registration> saveRegisters (List<Registration> listRegisters) {
        List<Registration> all = registrationRepository.saveAll(listRegisters);
        return all;
    }


    public Registration saveRegister (Registration register) {
        return registrationRepository.save(register);
    }

    public Optional<Registration> getById (Long id) {
        return registrationRepository.findById(id);
    }

    public Registration updateById (Registration request, Long id) {
        Registration aux = registrationRepository.findById(id).get();
        aux.setAssignments(request.getAssignments());
        registrationRepository.save(aux);
        return aux;

    }

    public Boolean deleteById (Long id) {
        try {
            registrationRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            registrationRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
