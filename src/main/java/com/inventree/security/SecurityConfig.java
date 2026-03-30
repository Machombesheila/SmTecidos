package com.inventree.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/tecidos/**", "/estoque/**")
                    .hasAnyRole("ADMIN", "FUNCIONARIO")
                .anyRequest().authenticated()
        )

        .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/tecidos", true)
                .permitAll()
        )

        .logout(logout -> logout.permitAll());

        return http.build();
    }
}
