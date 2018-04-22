package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.domains.DomainUser;

import java.util.List;

public interface IUserManager {
    List<DomainUser> getAllUsers();
    DomainUser getUserById(Long userId);
    DomainUser createUser(DomainUser domainUser);
    DomainUser updateUser(Long userId, DomainUser domainUser);
    DomainUser deleteUser(Long userId);
    DomainUser getUserByEmail(String email);
    List<DomainUser> getUsersByDates(Long startDate, Long endDate);
}
