package com.regmi.bijay.pasteit.security;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final Long userId;

    public AuthenticationResponse(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUserId() {
        return this.userId;
    }
}
