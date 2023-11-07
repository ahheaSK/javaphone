package com.makara.java.kit.javahome.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/","index.html","css/**","js/**").permitAll()
			//.antMatchers("/models").hasRole(RoleEnum.SALE.name())
			//.antMatchers(HttpMethod.POST, "/brands").hasAuthority("brand:write")
			//.antMatchers(HttpMethod.POST, "/brands").hasAuthority(BRAND_WRITE.getDescription())
			//.antMatchers(HttpMethod.GET, "/brands").hasAuthority(BRAND_READ.getDescription())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {	
		
		UserDetails user1 = User.builder()
				.username("dara")
				.password(passwordEncoder.encode("dara123"))
				//.roles(RoleEnum.SALE.name()) // ROLE_ADMIN
				.authorities(RoleEnum.SALE.getAuthorities()) // collection of GrantedAuthorrity
				.build();
		
		UserDetails user2 = User.builder()
				.username("thida")
				.password(passwordEncoder.encode("thida123"))
				//.roles("ADMIN") // ROLE_ADMIN
				.authorities(RoleEnum.ADMIN.getAuthorities()) // collection of GrantedAuthorrity
				.build();
				
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user1, user2);
		
		return userDetailsService;
	}
}
