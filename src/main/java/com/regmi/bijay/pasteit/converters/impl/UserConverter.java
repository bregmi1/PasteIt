package com.regmi.bijay.pasteit.converters.impl;

import com.regmi.bijay.pasteit.Application;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.converters.IUserConverter;
import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.views.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserConverter implements IUserConverter {

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public DomainUser viewToDomain(ViewUser viewUser) {
        DomainUser domainUser = new DomainUser();
        domainUser.setUserId(viewUser.getUserId());
        domainUser.setEmail(viewUser.getEmail());
        domainUser.setName(viewUser.getName());
        domainUser.setPassword(passwordEncoder.encode(viewUser.getPassword()));

        LocalDateTime now = LocalDateTime.now();
        domainUser.setUpdateOn(now);

        if(viewUser.getUserId() == null){
            domainUser.setCreatedOn(now);
        } else{
            domainUser.setCreatedOn(localDateTimeConverter.convertLongToLocalDateTime(viewUser.getCreatedOn()));
        }
        return domainUser;
    }

    @Override
    public ViewUser domainToView(DomainUser domainUser) {
        ViewUser viewUser = new ViewUser();
        viewUser.setUserId(domainUser.getUserId());
        viewUser.setName(domainUser.getName());
        viewUser.setEmail(domainUser.getEmail());
        viewUser.setCreatedOn(localDateTimeConverter.convertLocalDateTimeToLong(domainUser.getCreatedOn()));
        return viewUser;
    }
}
