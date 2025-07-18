package com.charlyCorporation.SecurityRoles.security.config;

import com.charlyCorporation.SecurityRoles.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtils jwtUtils;

    public CustomOAuth2SuccessHandler(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public void onAuthenticationSuccess(
            jakarta.servlet.http.HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        // 👤 Obtener nombre de usuario desde GitHub
        String username = oAuth2User.getAttribute("login");

        // 🔁 Simular una autenticación para usar createToken()
        Authentication fakeAuth = new UsernamePasswordAuthenticationToken(
                username, null, oAuth2User.getAuthorities()
        );

        // 🔐 Generar el token con tu método
        String token = jwtUtils.createToken(fakeAuth);

        // 📤 Devolver el token como JSON
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + token + "\"}");
    }
}
