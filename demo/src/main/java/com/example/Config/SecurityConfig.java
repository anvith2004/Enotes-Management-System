package com.example.Config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import jakarta.servlet.http.HttpSession;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.context.annotation.Bean;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     public UserDetailsService userDetailsService;

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     public DaoAuthenticationProvider daoAuthenticationProvider() {
//         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//         daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//         return daoAuthenticationProvider;
//     }

// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     http
//     .csrf(csrf -> csrf.disable()) // Disable CSRF protection
//     .authorizeHttpRequests(auth -> auth
//         .requestMatchers("/user/**").hasRole("USER") // Restrict access to /user/** to USER role
//         .requestMatchers("/**").permitAll() // Permit access to all other URLs
//     )
//     .formLogin(form -> form
//         .loginPage("/signin") // Custom login page
//         .loginProcessingUrl("/userLogin") // URL where the login form is submitted
//         .defaultSuccessUrl("/user/addNotes") // Redirect after successful login
//         .permitAll()
//     );
//     return http.build(); // Build the SecurityFilterChain
// }
// }

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public DaoAuthenticationProvider daoAuthenticationProvider() {
//         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//         daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//         return daoAuthenticationProvider;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//                 .csrf(csrf -> csrf.disable()) // Disable CSRF protection
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/user/**").hasRole("USER") // Restrict access to /user/** to USER role
//                         .requestMatchers("/**").permitAll() // Permit access to all other URLs
//                 )
//                 .formLogin(form -> form
//                         .loginPage("/signin") // Custom login page
//                         .loginProcessingUrl("/userLogin") // URL where the login form is submitted
//                         .defaultSuccessUrl("/user/addNotes") // Redirect after successful login
//                         .permitAll());
//         return http.build(); // Build the SecurityFilterChain
//     }

// }

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public DaoAuthenticationProvider daoAuthenticationProvider() {
//         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//         daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//         return daoAuthenticationProvider;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable()) // Disable CSRF protection
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/user/**").hasRole("USER") // Restrict access to /user/** to USER role
//                 .requestMatchers("/**").permitAll() // Permit access to all other URLs
//             )
//             .formLogin(form -> form
//                 .loginPage("/signin") // Custom login page
//                 .loginProcessingUrl("/userLogin") // URL where the login form is submitted
//                 .defaultSuccessUrl("/user/addNotes") // Redirect after successful login
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/user/logout") // Specify the logout URL
//                 .logoutSuccessUrl("/signin?logout") // Redirect after successful logout
//                 .invalidateHttpSession(true) // Invalidate session on logout
//                 .deleteCookies("JSESSIONID") // Delete cookies on logout
//                 .permitAll()
//             );

//         return http.build(); // Build the SecurityFilterChain
//     }

//     // If you want to explicitly define an AuthenticationManager bean
//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//         return authConfig.getAuthenticationManager();
//     }
// }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasRole("USER") // Restrict access to /user/** to USER role
                        .requestMatchers("/addNotes", "/viewNotes").authenticated() // Require authentication for
                                                                                    // addNotes and viewNotes
                        .requestMatchers("/**").permitAll() // Permit access to all other URLs
                )
                .formLogin(form -> form
                        .loginPage("/signin") // Custom login page
                        .loginProcessingUrl("/userLogin") // URL where the login form is submitted
                        .defaultSuccessUrl("/user/addNotes") // Redirect after successful login
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/user/logout") // Specify the logout URL
                        .logoutSuccessUrl("/signin?logout") // Redirect after successful logout
                        .invalidateHttpSession(true) // Invalidate session on logout
                        .deleteCookies("JSESSIONID") // Delete cookies on logout
                        .permitAll());

        return http.build(); // Build the SecurityFilterChain
    }

    // If you want to explicitly define an AuthenticationManager bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
