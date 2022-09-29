package com.rhsso.websecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    private final KeycloakLogoutHandler keycloakLogoutHandler;

    WebSecurityConfiguration(KeycloakLogoutHandler keycloakLogoutHandler) {
        this.keycloakLogoutHandler = keycloakLogoutHandler;
    }

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/api/*").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
                .and().logout().permitAll();

        http.oauth2Login()
                .and()
                .logout()
                .addLogoutHandler(keycloakLogoutHandler)
                .logoutSuccessUrl("/");

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

}