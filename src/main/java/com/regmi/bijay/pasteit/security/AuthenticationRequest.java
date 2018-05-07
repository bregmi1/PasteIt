package com.regmi.bijay.pasteit.security;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String email;
    private String password;

    public AuthenticationRequest() {
        super();
    }

    public AuthenticationRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
