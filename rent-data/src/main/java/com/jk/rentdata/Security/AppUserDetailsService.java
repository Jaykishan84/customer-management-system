package com.jk.rentdata.Security;

import com.jk.rentdata.UserEntity.AppUser;
import com.jk.rentdata.UserRepo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.findByName(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found.");
        }
        return new AppUserDetails(user);
    }
}
