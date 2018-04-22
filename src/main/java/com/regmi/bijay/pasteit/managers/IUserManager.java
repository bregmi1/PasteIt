package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.views.ViewUser;

import java.util.List;

public interface IUserManager {
    List<ViewUser> getAllUsers();
    ViewUser getUserById(Long userId);
    ViewUser createUser(ViewUser viewUser);
    ViewUser updateUser(Long userId, ViewUser viewUser);
    ViewUser deleteUser(Long userId);
    ViewUser getUserByEmail(String email);
    List<ViewUser> getUsersByDates(Long startDate, Long endDate);
}
