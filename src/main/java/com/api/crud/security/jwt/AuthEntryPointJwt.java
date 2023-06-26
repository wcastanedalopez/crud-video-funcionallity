package com.api.crud.security.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *Esta clase se utiliza para manejar los errores de autenticación y proporcionar una respuesta adecuada
 *  cuando un usuario no está autorizado para acceder a un recurso protegido.
 */
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    /**
     * Este método se activará cada vez que un usuario no autenticado solicite un recurso HTTP
     * seguro y se AuthenticationExceptionemita un correo electrónico.
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());

        //Init optional code

        //HttpServletResponse.SC_UNAUTHORIZEDes el código de estado 401 .
        // Indica que la solicitud requiere autenticación HTTP.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");

        /**  OPTIONAL CODE ->
         *   response.setContentType(MediaType.APPLICATION_JSON_VALUE);
         *   response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         *
         *   final Map<String, Object> body = new HashMap<>();
         *   body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
         *   body.put("error", "Unauthorized");
         *   body.put("message", authException.getMessage());
         *   body.put("path", request.getServletPath());
         *
         *   final ObjectMapper mapper = new ObjectMapper();
         *   mapper.writeValue(response.getOutputStream(), body);
         */
    }
}