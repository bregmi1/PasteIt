package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.domains.User;
import com.sun.tools.javac.util.List;

public interface IUserManager {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User user);
    User deleteUser(Long userId);
    User getUserByPasteId(Long pasteId);
}
