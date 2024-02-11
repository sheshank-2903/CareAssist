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
	public UserDetailsService userDetailService() {
		
		return new UserInfoDetailsService();
	}
	
	
	@Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
    	
    		return http.csrf().disable()
    			.authorizeHttpRequests().requestMatchers("/v3/api-docs/**"
    					, "/swagger-ui/**"
    					, "/swagger-resources/**"
    					,"/api/v1/healthcareprovider/add"
    					,"/api/v1/insurancecompany/add"
    					,"/api/v1/patient/add"
    					,"/api/v1/healthcareprovider/authenticate"
    					,"/api/v1/insurancecompany/authenticate"
    					,"/api/v1/patient/authenticate"
    					,"/api/v1/admin/authenticate"
    					,"/api/v1/admin/add"
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
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
    	return config.getAuthenticationManager();
    	
    }
    
    

    @Bean    
    public PasswordEncoder passwordEncoder() {          
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

	
	
}
