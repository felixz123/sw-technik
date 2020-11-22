package com.project.zulassungssystem;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;
    
    
    @Override
    public UserDetails loadUserByUsername(String pEmail) throws UsernameNotFoundException{
       Optional<User> user = userRepo.findByEmail(pEmail);

       user.orElseThrow(() -> new UsernameNotFoundException("E-Mail "+pEmail+" not registered."));
       return user.map(CustomUserDetails::new).get();
       
    }
}
