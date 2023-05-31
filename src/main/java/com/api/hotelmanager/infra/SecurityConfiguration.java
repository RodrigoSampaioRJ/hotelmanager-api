package com.api.hotelmanager.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	return http
    			.authorizeHttpRequests(authorizationConfig -> {
    				authorizationConfig.requestMatchers("/login");
    				authorizationConfig.requestMatchers("/logout").permitAll();
    				authorizationConfig.anyRequest().permitAll();
    			})
    			.oauth2Login(Customizer.withDefaults())
				.csrf().disable()
    			.build();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//          .inMemoryAuthentication()
//          .withUser("user1")
//          .password(passwordEncoder().encode("user1Pass"))
//          .authorities("ROLE_USER");
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
