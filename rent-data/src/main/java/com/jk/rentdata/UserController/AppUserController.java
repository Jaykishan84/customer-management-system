package com.jk.rentdata.UserController;

import com.jk.rentdata.UserEntity.AppUser;
import com.jk.rentdata.UserRepo.AppUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

@RestController
public class AppUserController {

    @Autowired
    private AppUserRepo repo;

    @RequestMapping("/")
    public Iterable<AppUser> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping("/addUser")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) throws ServerException {
        AppUser savedUser = repo.save(user);
        if(savedUser==null)
            throw new ServerException("User not created.");
        else
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
