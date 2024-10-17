/**package com.example.accessingdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login.html", "/register.html", "/styles.css").permitAll()  // Páginas públicas
                        .requestMatchers("/index.html").authenticated()  // index.html requiere autenticación
                        .requestMatchers("/properties/**").authenticated()  // Todas las rutas de properties requieren autenticación
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login.html")  // Página de login servida por Apache
                        .defaultSuccessUrl("/index.html", true)  // Redirigir a index.html después de login exitoso
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login.html")  // Después de logout, redirigir a login.html
                        .permitAll()
                );

        return http.build();
    }


}**/