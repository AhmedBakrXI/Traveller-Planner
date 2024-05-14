package com.traveller.planner.configuration;

import com.traveller.planner.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for setting up Spring Security for the application.
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * Configures the security filter chain.
     *
     * @param httpSecurity the HttpSecurity to modify
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs while configuring the security filter chain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                    registry.requestMatchers("/login", "/register").permitAll();
                    registry.requestMatchers("/api/city").permitAll();
                    registry.anyRequest().authenticated();
//                    registry.anyRequest().permitAll();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .loginPage("/login")
                            .successHandler(new MyAuthenticationSuccessHandler())
                            .permitAll();
                })
                .build();
    }

    /**
     * Exposes the custom UserDetailsService as a bean.
     *
     * @return the custom UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    /**
     * Configures the authentication provider.
     *
     * @return the configured AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Configures the password encoder to use BCrypt.
     *
     * @return the BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
