package com.moz.ates.traffic.office.main;


import org.springframework.security.core.userdetails.User;

import com.moz.ates.traffic.office.config.AuthenticationEntity;


public class SecurityAccount extends User {


    public SecurityAccount(AuthenticationEntity authenticationEntity) {
        super(authenticationEntity.getOprtrAccountId(), authenticationEntity.getOprtrAccountPw(), authenticationEntity.getAuthorities());
    }
}
