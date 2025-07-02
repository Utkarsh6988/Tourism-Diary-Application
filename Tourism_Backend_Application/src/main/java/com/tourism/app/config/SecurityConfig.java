//package com.tourism.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // Disable CSRF for development only
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/", "/diary", "/packages", "/css/**", "/js/**").permitAll() // public pages
//                .requestMatchers("/bookings/**").authenticated() // protect bookings
//                .requestMatchers("/api/**").authenticated()
//                .anyRequest().permitAll() // allow other misc endpoints
//            )
//            .formLogin(form -> form
//                .loginPage("/login") // custom login page (create a login.html)
//                .permitAll()
//            )
//            .logout(logout -> logout
//            	    .logoutSuccessUrl("/logout-success") // <-- change this
//            	    .permitAll()
//            	);
//        return http.build();
//    }
//}
//
package com.tourism.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .ignoringRequestMatchers("/api/auth/**")) // Disable CSRF for API auth endpoints) // optional: for dev only
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll()  // allow everything
                // OR use more granular rules like below
                //.requestMatchers("/", "/login", "/register", "/css/**", "/js/**").permitAll()
                //.requestMatchers("/bookings/**").authenticated()
                //.anyRequest().permitAll()
            )
            .formLogin(form -> form.disable()) // 🔴 DISABLE Spring's form login
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );
        return http.build();
    }

    // INSECURE CONFIGURATION - FOR DEVELOPMENT ONLY
    @Bean 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Secure password encoding
    }
    

}
