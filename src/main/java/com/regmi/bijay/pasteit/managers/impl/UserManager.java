package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.converters.IUserConverter;
import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IUserManager;
import com.regmi.bijay.pasteit.views.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
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
        DomainUser user = userAccessor.findOne(userId);
        if(user == null){
            throw new EntityNotFoundException("Unable to retrieve the user with id: " + userId.toString());
        }
        return userConverter.domainToView(user);
    }

    @Override
    public ViewUser createUser(ViewUser viewUser) {
        if(viewUser == null){
            throw new InvalidParameterException("Provided null user for creation");
        }
        return userConverter.domainToView(userAccessor.save(userConverter.viewToDomain(viewUser)));
    }

    @Override
    public ViewUser updateUser(Long userId, ViewUser viewUser) {
        DomainUser currentDomainUser = userAccessor.findOne(userId);
        if(currentDomainUser == null){
            throw new EntityNotFoundException("Unable to retrieve the user with id: " + userId.toString());
        } else if(! viewUser.getUserId().equals(userId)){
            throw new InvalidParameterException("Provided user id: " + userId.toString() +
                    " does not match with provided user: " + viewUser.toString());        }
        return userConverter.domainToView(userAccessor.save(userConverter.viewToDomain(viewUser)));
    }

    @Override
    public ViewUser deleteUser(Long userId) {
        DomainUser domainUser = userAccessor.findOne(userId);
        if(domainUser == null){
            throw new EntityNotFoundException("Unable to retrieve the user with id: " + userId.toString());
        }
        userAccessor.delete(userId);
        return userConverter.domainToView(domainUser);
    }

    @Override
    public ViewUser getUserByEmail(String email) {
        DomainUser user = userAccessor.findByEmail(email);
        if(user == null){
            throw new EntityNotFoundException("Unable to retrieve the user with email: " + email);
        }
        return userConverter.domainToView(user);
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
