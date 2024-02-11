package com.hexaware.careassist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.careassist.filter.JWTAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	JWTAuthFilter authFilter; 
	
	
	@Bean
	 UserDetailsService userDetailService() {
		
		return new UserInfoDetailsService();
	}
	
	
	@Bean
     SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
    	
    		return http.csrf().disable()
    			.authorizeHttpRequests().requestMatchers("/v3/api-docs/**"
    					, "/swagger-ui/**"
    					, "/swagger-resources/**"
    					,"/api/v1/healthcareprovider/register"
    					,"/api/v1/insurancecompany/register"
    					,"/api/v1/patient/register"
    					,"/api/v1/healthcareprovider/login"
    					,"/api/v1/insurancecompany/login"
    					,"/api/v1/patient/login"
    					,"/api/v1/admin/login"
    					,"/api/v1/admin/register"
    					).permitAll()
    			.and()
    			.authorizeHttpRequests().requestMatchers("/api/v1/healthcareprovider/**"
    					,"/api/v1/patient/**"
    					,"/api/v1/admin/**"
    					,"/api/v1/claims/**"
    					,"/api/v1/insurancecompany/**"
    					,"/api/v1/invoice/**"
    					,"/api/v1/plans/**")
    			.authenticated().and() 
    			.sessionManagement()
    			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    			.and()
    			.authenticationProvider(authenticationProvider())
    			.addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class)
    			.build();
    			
    }
	

	@Bean
     AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
    	return config.getAuthenticationManager();
    	
    }
    
    

    @Bean    
     PasswordEncoder passwordEncoder() {          
        return new BCryptPasswordEncoder();
    }

    @Bean
     AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

	
	
}
