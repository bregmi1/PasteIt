package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    List<DomainUser> getAllUsers(){
        return userManager.getAllUsers();
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    DomainUser getUser(@PathVariable Long userId){
        return userManager.getUserById(userId);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    DomainUser getUserByEmail(@RequestParam String email){
        return null;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    DomainUser createUser(@RequestBody DomainUser domainUser){
        return userManager.createUser(domainUser);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    DomainUser updateUser(@PathVariable Long userId, @RequestBody DomainUser domainUser){
        return userManager.updateUser(userId, domainUser);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    DomainUser deleteUser(@PathVariable Long userId){
        return userManager.deleteUser(userId);
    }
    
}
