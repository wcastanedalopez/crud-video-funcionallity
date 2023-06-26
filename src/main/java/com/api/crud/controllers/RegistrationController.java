package com.api.crud.controllers;

import com.api.crud.models.Registration;
import com.api.crud.services.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/registration")
@RepositoryRestResource(path = "registers", collectionResourceRel = "registers")
@CrossOrigin
public class RegistrationController {


    @Autowired
    private RegistrationServiceImpl registrationServiceImpl;

    @GetMapping
    public List<Registration> getRegisters(){
        return this.registrationServiceImpl.getRegisters();
    }

    @PostMapping
    public Registration saveRegister(@RequestBody Registration register){
        return this.registrationServiceImpl.saveRegister(register);
    }

    @PostMapping(path = "/addList")
    public List<Registration> saveByListRegisters(@RequestBody List<Registration> registers){
        return this.registrationServiceImpl.saveRegisters(registers);
    }

    @GetMapping (path = "/{id}")
    public Optional<Registration> getRegisterById(@PathVariable Long id) {
        return this.registrationServiceImpl.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Registration updateRegisterById (@RequestBody Registration register, Long id ) {
        return this.registrationServiceImpl.updateById(register, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRegisterById ( @PathVariable ("id") Long id) {
        boolean ok = this.registrationServiceImpl.deleteById(id);

        if (ok ) {
            return "Register with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete register with this id";
        }
    }

    @DeleteMapping
    public String deleteRegisters () {
        boolean ok = this.registrationServiceImpl.deleteAll();

        if (ok ) {
            return "All registers were eliminated";
        } else {
            return "Error, we have a problem for delete registers with this id";
        }
    }





}
