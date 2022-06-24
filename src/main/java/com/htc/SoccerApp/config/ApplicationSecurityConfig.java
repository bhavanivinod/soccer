package com.htc.SoccerApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.htc.SoccerApp.filter.JwtFilter;
import com.htc.SoccerApp.service.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableAspectJAutoProxy
@EnableWebSecurity
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	   @Autowired
	    private CustomUserDetailsService userDetailsService;

	    @Autowired
	    private JwtFilter jwtFilter;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    }

	    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests().antMatchers("/authenticate")
//			        .permitAll().antMatchers("/participant")
			        .permitAll().antMatchers("/teamList")
                    .permitAll().antMatchers(HttpMethod.OPTIONS,"/**")
	                .permitAll().anyRequest().authenticated()
	                .and().exceptionHandling().and().sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
	    }

	
	
	
	
	
	
	
	
	
	
	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {   //user repository.
//		//in memory authentication.
//		auth.inMemoryAuthentication().withUser("htcuser").password("123Welcome").roles("EMPLOYEE");
//		auth.inMemoryAuthentication().withUser("superadmin").password("123456").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("syamams").password("1234567").roles("USER");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {   //authorization logic
//		http.cors();
//		http.csrf().disable();
//		http.authorizeRequests()
//			.antMatchers("/*").fullyAuthenticated()
//			.and().httpBasic();
//	}
//
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//	
//
//	
}

