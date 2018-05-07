package com.regmi.bijay.pasteit.security;

import com.regmi.bijay.pasteit.Application;
import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.domains.DomainUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserAccessor IUserAccessor;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        DomainUser user = IUserAccessor.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            return user;
        }
    }
}
