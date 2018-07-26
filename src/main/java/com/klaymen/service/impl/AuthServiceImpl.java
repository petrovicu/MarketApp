package com.klaymen.service.impl;

import com.klaymen.security.MarketAppAuthenticationProvider;
import com.klaymen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MarketAppAuthenticationProvider marketAppAuthenticationProvider;

    @Override
    public void authenticateUser(String email, String password) {
        marketAppAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }
}
