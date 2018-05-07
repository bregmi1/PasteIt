package com.regmi.bijay.pasteit.controllers.v1;


import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.security.AuthenticationRequest;
import com.regmi.bijay.pasteit.security.AuthenticationResponse;
import com.regmi.bijay.pasteit.security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController {

    @Value("${pasteit.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "${pasteit.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final DomainUser userDetails = (DomainUser) userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = tokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new AuthenticationResponse(token, userDetails.getUserId()));
    }

    @RequestMapping(value = "${pasteit.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = tokenUtil.getEmailFromToken(token);
        DomainUser user = (DomainUser) userDetailsService.loadUserByUsername(username);

        if (tokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = tokenUtil.refreshToken(token);
            return ResponseEntity.ok(new AuthenticationResponse(refreshedToken, user.getUserId()));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
