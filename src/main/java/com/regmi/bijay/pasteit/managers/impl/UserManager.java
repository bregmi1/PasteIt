package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.domains.Paste;
import com.regmi.bijay.pasteit.domains.User;
import com.regmi.bijay.pasteit.managers.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserManager implements IUserManager {

    @Autowired
    private IUserAccessor userAccessor;


    @Override
    public List<User> getAllUsers() {
        return userAccessor.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userAccessor.findOne(userId);
    }

    @Override
    public User createUser(User user) {
        return userAccessor.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User currentUser = userAccessor.findOne(userId);
        if(currentUser == null || !user.getUserId().equals(userId)){
            return null;
        }
        return userAccessor.save(user);
    }

    @Override
    public User deleteUser(Long userId) {
        User user = userAccessor.findOne(userId);
        if(user == null){
            return null;
        }
        userAccessor.delete(userId);
        return user;
    }

    @Override
    public User getUserByPaste(Paste paste) {
        return null;
    }
}
