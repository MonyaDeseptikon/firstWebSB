package ru.monya.firstWebSB.springSecurity;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import ru.monya.firstWebSB.notesSpringBootDatabase.NoteService;


@Configuration
@EnableWebSecurity
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
//                .cors((c)->c.)
                .csrf((csrf) -> csrf.ignoringRequestMatchers("/api/notes/**", "/api/notes"))
                .authorizeHttpRequests(req -> req
                        //SpringSecurity это , наверно, самое мудреное из всего Спринга
                        //Сопоставитель не видит путь, но видит имя страницы к которой путь ведет
                        .requestMatchers("/", "/home", "/homepage.html", "/css/**", "/howItsWas", "/how-its-was.html",
                                "/swagger-ui/index.html", "/swagger-ui/**", "/v3/api-docs/**", "/api/notes/**", "/api/notes", "/pic/**").permitAll())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/springsecurity", "/spring-security.html").hasRole("USER")
//
                        .anyRequest().authenticated())
                .formLogin(fl -> fl.permitAll())
                // Два дня ушло на то , чтобы понять , базовая HTTPшная аутентификация не корректно работает со SpringSecurity. В итоге использовал нативную аутентификацию SpringSecurity и все решилось за две верхние строки.
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder;
        encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}


//                .requestCache((cache) -> cache
//                        .requestCache(nullRequestCache))
//                .sessionManagement((session) -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))


//                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
//                //        Добавляем наш фильтр аутентификации
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                // Не создаем сессию, так как будем использовать JWT


//                .csrf((csrf) -> csrf
//                        .ignoringRequestMatchers("/"))
//                .csrf(AbstractHttpConfigurer::disable)


//        RequestCache nullRequestCache = new NullRequestCache();
//        String realmName = "springsecurity";
//        BasicAuthenticationEntryPoint entryPoint= new BasicAuthenticationEntryPoint();
//        entryPoint.setRealmName(realmName);


//                .requestCache((cache) -> cache.requestCache(new NullRequestCache()))

//                .httpBasic(c -> c.authenticationEntryPoint(
//                        (request, response, authException) -> response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase())))

// .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()

//                .httpBasic(Customizer.withDefaults())

//                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))


//                .rememberMe(r->r.alwaysRemember(true))
//                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionFixation().none())

//                .sessionManagement(sessionManagement -> sessionManagement.maximumSessions(1))

//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

//.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(httpBasic -> httpBasic.securityContextRepository(new NullSecurityContextRepository()))