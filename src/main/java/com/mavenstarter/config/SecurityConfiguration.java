package com.mavenstarter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfiguration {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("password")
                .roles("ADMIN");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home", "/check")
                        .permitAll()
                        .requestMatchers("/delete")
                        .hasRole("ADMIN")
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(config -> config.loginPage("/login").permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

}
