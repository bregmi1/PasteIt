package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IUserManager;
import com.regmi.bijay.pasteit.views.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    List<ViewUser> getAllUsers(){
        return userManager.getAllUsers();
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    ViewUser getUser(@PathVariable Long userId){
        return userManager.getUserById(userId);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    ViewUser getUserByEmail(@RequestParam String email){
        return null;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    ViewUser createUser(@RequestBody ViewUser viewUser){
        return userManager.createUser(viewUser);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    ViewUser updateUser(@PathVariable Long userId, @RequestBody ViewUser viewUser){
        return userManager.updateUser(userId, viewUser);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    ViewUser deleteUser(@PathVariable Long userId){
        return userManager.deleteUser(userId);
    }
    
}
