package com.api.crud.services;

import com.api.crud.models.ERole;
import com.api.crud.models.Role;
import com.api.crud.models.User;
import com.api.crud.dto.UserDto;
import com.api.crud.exception.EmailAlreadyExistsException;
import com.api.crud.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserService {//implements UserDetailsService, UserService {


    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRepository IUserRepository;


    @Autowired
    private PasswordEncoder bcryptEncoder;


    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        IUserRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User save(UserDto user) {

        User nUser = user.getUserFromDto();

        if(IUserRepository.existsByEmail(nUser.getEmail()))
            throw new EmailAlreadyExistsException("Email ocupado");

        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));  //Se encripta la contraseña


        //Por defecto se le asigna el rol de usuario
        Role role = roleService.findByName(ERole.ROLE_USER);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        //Ahora valida que tenga un dominio de administrador en su email
        if(nUser.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName(ERole.ROLE_ADMIN);
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return IUserRepository.save(nUser);
    }



    @Override
    public User findOne(String username) {
        Optional<User> optionalUser = IUserRepository.findByUsername(username);

        return optionalUser.orElse(null);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return IUserRepository.findByUsername(username) != null ? true: false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return IUserRepository.existsByEmail(email);
    }


//    /**
//     * En resumen, este bloque de código busca un usuario en la base de datos por su nombre de usuario,
//     * valida su existencia y crea un objeto UserDetails que representa al usuario autenticado en el
//     * sistema. Las autoridades asociadas al usuario se obtienen a través del método getAuthority.
//     * Este método es responsable de mapear los roles o permisos del usuario a objetos GrantedAuthority,
//     * que se utilizan posteriormente para la autenticación y autorización en Spring Security.
//     * @param username
//     * @return
//     * @throws UsernameNotFoundException
//     */
//    public User loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> optionalUser = userRepository.findByUsername(username);
//        if(optionalUser == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(optionalUser, user.getPassword(), getAuthority(user));
//    }


//    /**
//     * En resumen, las autoridades (SimpleGrantedAuthority) son objetos que representan los roles o
//     * permisos de un usuario en un sistema basado en Spring Security. Son utilizados por Spring
//     * Security para realizar comprobaciones de autenticación y autorización y determinar qué acciones
//     * están permitidas para un usuario en particular.
//     * @param user
//     * @return
//     */
//    private Set<SimpleGrantedAuthority> getAuthority(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//        });
//        return authorities;
//    }
}
