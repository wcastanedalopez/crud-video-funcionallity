package com.api.crud.security.jwt;
import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.crud.security.services.UserDetailsServiceImpl;

/**
 * Filters incoming requests and installs a Spring Security principal if a header corresponding to a valid user is
 * found.
 * Se ejecuta por cada petición entrante con el fin de validar el token JWT
 * en caso de que lo sea se añade al contexto para indicar que un usuario está autenticado
 */

public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    /**
     * Lo que se hace en el interior doFilterInternal():
     * - obtener JWTde las cookies HTTP
     * – si la solicitud tiene JWT, validarla, analizarla username–
     * desde username, llegar UserDetails a crear un Authenticationobjeto
     * – establecer el actual UserDetailsen SecurityContext usando setAuthentication(authentication)el método.
     * Después de esto, cada vez que se quiera obtener UserDetails, solo se usa SecurityContext: UserDetails userDetails =
     * 	(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            //para obtener el token JWT de la solicitud
            String jwt = parseJwt(request);

            //se verifica si el token es válido
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {

                //se extrae el nombre de usuario del token y se cargan los detalles del usuario
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);


                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,
                                userDetails.getAuthorities());

                //Se establecen los detalles de autenticación.
                // Lo que proporciona información adicional sobre la solicitud en el objeto de autenticación.
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //Finalmente, se establece la autenticación en el contexto de seguridad utilizando
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // Esto permite que el sistema de seguridad de la aplicación reconozca al usuario autenticado
                // en las solicitudes posteriores.
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String jwt = jwtUtils.getJwtFromCookies(request);
        return jwt;
    }
}
