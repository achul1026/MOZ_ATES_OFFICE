package com.moz.ates.traffic.office.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class AuthenticationEntity {
    private String oprtrAccountId;
    private String oprtrAccountPw;
    private Collection<? extends GrantedAuthority> authorities;
}
