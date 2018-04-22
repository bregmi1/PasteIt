package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.converters.IUserConverter;
import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IUserManager;
import com.regmi.bijay.pasteit.views.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserManager implements IUserManager {

    @Autowired
    private IUserAccessor userAccessor;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @Autowired
    private IUserConverter userConverter;


    @Override
    public List<ViewUser> getAllUsers() {
        return userAccessor.findAll().stream()
                .map(userConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewUser getUserById(Long userId) {
        return userConverter.domainToView(userAccessor.findOne(userId));
    }

    @Override
    public ViewUser createUser(ViewUser viewUser) {
        return userConverter.domainToView(userAccessor.save(userConverter.viewToDomain(viewUser)));
    }

    @Override
    public ViewUser updateUser(Long userId, ViewUser viewUser) {
        DomainUser currentDomainUser = userAccessor.findOne(userId);
        if(currentDomainUser == null || !viewUser.getUserId().equals(userId)){
            return null;
        }
        return userConverter.domainToView(userAccessor.save(userConverter.viewToDomain(viewUser)));
    }

    @Override
    public ViewUser deleteUser(Long userId) {
        DomainUser domainUser = userAccessor.findOne(userId);
        if(domainUser == null){
            return null;
        }
        userAccessor.delete(userId);
        return userConverter.domainToView(domainUser);
    }

    @Override
    public ViewUser getUserByEmail(String email) {
        return userConverter.domainToView(userAccessor.findByEmail(email));
    }

    @Override
    public List<ViewUser> getUsersByDates(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return userAccessor.findAllByCreatedOnAfterAndCreatedOnBefore(ldtStartDate, ldtEndDate)
                .stream()
                .map(userConverter::domainToView)
                .collect(Collectors.toList());
    }
}
