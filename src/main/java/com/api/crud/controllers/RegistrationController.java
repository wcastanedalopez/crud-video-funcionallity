package com.api.crud.controllers;

import com.api.crud.models.Registration;
import com.api.crud.models.Route;
import com.api.crud.services.RegistrationService;
import com.api.crud.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registration")
@RepositoryRestResource(path = "registers", collectionResourceRel = "registers")
@CrossOrigin
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<Registration> getRegisters(){
        return this.registrationService.getRegisters();
    }

    @PostMapping
    public Registration saveRegister(@RequestBody Registration register){
        return this.registrationService.saveRegister(register);
    }

    @PostMapping(path = "/addList")
    public List<Registration> saveByListRegisters(@RequestBody List<Registration> registers){
        return this.registrationService.saveRegisters(registers);
    }

    @GetMapping (path = "/{id}")
    public Optional<Registration> getRegisterById(@PathVariable Long id) {
        return this.registrationService.getById(id);
    }

    @PostMapping(path = "/{id}")
    public Registration updateRegisterById (@RequestBody Registration register, Long id ) {
        return this.registrationService.updateById(register, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRegisterById ( @PathVariable ("id") Long id) {
        boolean ok = this.registrationService.deleteById(id);

        if (ok ) {
            return "Register with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete register with this id";
        }
    }

    @DeleteMapping
    public String deleteRegisters () {
        boolean ok = this.registrationService.deleteAll();

        if (ok ) {
            return "All registers were eliminated";
        } else {
            return "Error, we have a problem for delete registers with this id";
        }
    }





}
