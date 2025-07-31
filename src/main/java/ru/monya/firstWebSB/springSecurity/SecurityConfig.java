package ru.monya.firstWebSB.springSecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


@Configuration
@EnableWebSecurity
//@EnableWebMvc &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&???????????????????????????????????????????
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http

//                .csrf((csrf) -> csrf
//                        .ignoringRequestMatchers("/"))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
//                        .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()
                        //Сопоставитель не видит путь, но видит имя страницы к которой путь ведет
                        .requestMatchers("/", "/home", "/homepage.html", "/css/**", "/howItsWas", "/howItsWas.html",
                                "/swagger-ui/index.html", "/swagger-ui/**", "/v3/api-docs/**", "/api/notes/**", "/api/notes").permitAll())

                .authorizeHttpRequests(req -> req
                        .requestMatchers("/springsecurity", "/springsecurity.html").hasRole("USER")
                        .requestMatchers("/admin").hasRole("ADMIN"))
//                .anyRequest().authenticated()
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder;
        encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}