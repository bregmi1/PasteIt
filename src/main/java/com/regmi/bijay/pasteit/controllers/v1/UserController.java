package com.regmi.bijay.pasteit.controllers.v1;

import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IUserManager;
import com.regmi.bijay.pasteit.views.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewUser>> getAllUsers(){
        return new ResponseEntity<>(userManager.getAllUsers(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    ResponseEntity<ViewUser> getUser(@PathVariable Long userId){
        return new ResponseEntity<>(userManager.getUserById(userId), HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<ViewUser> getUserByEmail(@RequestParam String email){
        return new ResponseEntity<>(userManager.getUserByEmail(email), HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewUser> createUser(@RequestBody ViewUser viewUser){
        return new ResponseEntity<>(userManager.createUser(viewUser), HttpStatus.OK);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    ResponseEntity<ViewUser> updateUser(@PathVariable Long userId, @RequestBody ViewUser viewUser){
        return new ResponseEntity<>(userManager.updateUser(userId, viewUser), HttpStatus.OK);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewUser> deleteUser(@PathVariable Long userId){
        return new ResponseEntity<>(userManager.deleteUser(userId), HttpStatus.OK);
    }
    
}
