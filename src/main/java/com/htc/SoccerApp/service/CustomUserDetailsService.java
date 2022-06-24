package com.htc.SoccerApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.htc.SoccerApp.model.Roles;
import com.htc.SoccerApp.model.User;
import com.htc.SoccerApp.repository.UserRepository;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository repository;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	       User user = repository.findByUserName(username);
	       return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user));

	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        System.out.println(user);
        for(Roles userRole : user.getRoles()){
            System.out.println("UserRole : "+userRole);
            roles.add(new SimpleGrantedAuthority(userRole.getType()));
        }
        //System.out.print("authorities : "+roles);
        return roles;
    }
	
	
}
