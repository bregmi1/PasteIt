package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.domains.Paste;
import com.regmi.bijay.pasteit.domains.User;

import java.util.List;

public interface IUserManager {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User user);
    User deleteUser(Long userId);
    User getUserByEmail(String email);
    List<User> getUsersByDates(Long startDate, Long endDate);
}
