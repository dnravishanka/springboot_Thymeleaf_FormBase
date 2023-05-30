package com.example.springformbase_thymeleaf.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    // =========defautlPasswordEncorder is not safe and is to be deprecated=====

    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("manager")
                .password("1234")
                .roles("MANAGER")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);


    }*/

    //-------------PasswordEncoder for better Encoding --------
   /* @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().username("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.builder().username("manager")
                .password(passwordEncoder().encode("1234"))
                .roles("MANAGER")
                .build();
        UserDetails user3 = User.builder().username("nadun")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
*/


   @Bean
    public UserDetailsService userDetailsService() {
        return new AppUserDetailsService();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        //csrf().disable() --> for activate post,delete,put method    / without this only allowed for GET method
        httpSecurity

                .authorizeHttpRequests((auth)->auth
                        .requestMatchers("/api/v/customer/all").hasRole("ADMIN")
                        .requestMatchers("/api/v/customer/").hasRole("ADMIN")
                        .requestMatchers("/api/v/customer/address").hasRole("ADMIN")
                        .requestMatchers("/api/v/customer/id").hasAnyRole("MANAGER","ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic();
//        httpSecurity.csrf().disable();
        return httpSecurity.build();

    }
   @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
