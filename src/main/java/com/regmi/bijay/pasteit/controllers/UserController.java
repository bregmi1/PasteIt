package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.domains.User;
import com.regmi.bijay.pasteit.managers.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    List<User> getAllUsers(){
        return userManager.getAllUsers();
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    User getUser(@PathVariable Long userId){
        return userManager.getUserById(userId);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    User getUserByEmail(@RequestParam String email){
        return null;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    User createUser(@RequestBody User user){
        return userManager.createUser(user);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    User updateUser(@PathVariable Long userId, @RequestBody User user){
        return userManager.updateUser(userId, user);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    User deleteUser(@PathVariable Long userId){
        return userManager.deleteUser(userId);
    }
    
}
