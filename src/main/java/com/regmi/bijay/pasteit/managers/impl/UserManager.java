package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserManager implements IUserManager {

    @Autowired
    private IUserAccessor userAccessor;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;


    @Override
    public List<DomainUser> getAllUsers() {
        return userAccessor.findAll();
    }

    @Override
    public DomainUser getUserById(Long userId) {
        return userAccessor.findOne(userId);
    }

    @Override
    public DomainUser createUser(DomainUser domainUser) {
        return userAccessor.save(domainUser);
    }

    @Override
    public DomainUser updateUser(Long userId, DomainUser domainUser) {
        DomainUser currentDomainUser = userAccessor.findOne(userId);
        if(currentDomainUser == null || !domainUser.getUserId().equals(userId)){
            return null;
        }
        return userAccessor.save(domainUser);
    }

    @Override
    public DomainUser deleteUser(Long userId) {
        DomainUser domainUser = userAccessor.findOne(userId);
        if(domainUser == null){
            return null;
        }
        userAccessor.delete(userId);
        return domainUser;
    }

    @Override
    public DomainUser getUserByEmail(String email) {
        return userAccessor.findByEmail(email);
    }

    @Override
    public List<DomainUser> getUsersByDates(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return userAccessor.findAllByCreatedOnAfterAndCreatedOnBefore(ldtStartDate, ldtEndDate);
    }
}
