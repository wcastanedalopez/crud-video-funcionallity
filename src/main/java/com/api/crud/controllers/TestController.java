package com.api.crud.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para pruebas Autorización
 *
 * Hay 4 APIs:
 * – /api/test/allpara acceso público
 * – /api/test/userpara usuarios tiene ROLE_USERo ROLE_MODERATORo ROLE_ADMIN
 * – /api/test/modpara usuarios tiene ROLE_MODERATOR
 * – /api/test/adminpara usuarios tieneROLE_ADMIN
 * Ahora podemos asegurar métodos en nuestras Apis con @PreAuthorize anotaciones fácilmente.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
