package com.jk.rentdata.UserRepo;

import com.jk.rentdata.UserEntity.AppUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    
    AppUser findByName(String name);
}
