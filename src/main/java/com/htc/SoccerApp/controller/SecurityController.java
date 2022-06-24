package com.htc.SoccerApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.SoccerApp.model.AuthRequest;
import com.htc.SoccerApp.model.AuthResponse;
import com.htc.SoccerApp.model.Roles;
import com.htc.SoccerApp.model.User;
import com.htc.SoccerApp.service.CustomUserDetailsService;
import com.htc.SoccerApp.service.ParticipantService;
import com.htc.SoccerApp.util.JwtUtil;




@RestController 
public class SecurityController {
    @Autowired
    private JwtUtil jwtUtil;
   
    @Autowired
    private AuthenticationManager authenticationManager;
    
	@Autowired
	private ParticipantService participantService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
    
    @GetMapping("/")
    public String welcome() {
        return "Welcome to SpringBootSecurity !!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUserName());
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwt, userDetails.getUsername(),getroleAuthorities(userDetails)) );
    }
    
	   @GetMapping(value="/checkRole/{username}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Set<Roles> getRole(@PathVariable("username")String  username)
		{
			Set<Roles> role =participantService.checkRole(username);
	        return role;
		}
    
    private List<String> getroleAuthorities(UserDetails userDetails){
    	//System.out.println("calling getrole");
        List<String> roles = new ArrayList<String>();
         
        for(GrantedAuthority userRole : userDetails.getAuthorities()){
            //System.out.println("UserRole : "+userRole.getAuthority());
            roles.add(userRole.getAuthority());
        }
        //System.out.print("authorities : "+roles);
        return roles;
    }
	
}
