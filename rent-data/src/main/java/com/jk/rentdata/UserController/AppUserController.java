package com.jk.rentdata.UserController;

import com.jk.rentdata.UserEntity.AppUser;
import com.jk.rentdata.UserRepo.AppUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Optional;

@RestController
public class AppUserController {

    @Autowired
    private AppUserRepo repo;

    //GETTING ALL USERS.
    @RequestMapping("/")
    public Iterable<AppUser> getAllUsers() {
        return repo.findAll();
    }

    //ADDING NEW USERS.
    @PostMapping("/addUser")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) throws ServerException {
        AppUser savedUser = repo.save(user);
        if(savedUser==null)
            throw new ServerException("User not created.");
        else
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //FETCHING USER BY ID
    @GetMapping("/getUserById/{id}")
    public Optional<AppUser> getUserById(@PathVariable Long id) throws ServerException {
        Optional<AppUser> user = repo.findById(id);
        if(user==null)
            throw new ServerException("User not found.");
        else
            return user;
    }

    //UPDATING THE USER.
    @PutMapping("/updateById/{id}")
    public ResponseEntity<AppUser> updateUserById(@RequestBody AppUser user) throws ServerException {
        AppUser updatedUser = repo.save(user);
        if(updatedUser==null)
            throw new ServerException("User not updated.");
        else
            return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    //DELETING THE USER.
    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Long id){
        repo.deleteById(id);
    }
}
