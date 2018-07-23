package com.klaymen.service.impl;

import com.klaymen.domain.Customer;
import com.klaymen.repository.AuthRepository;
import com.klaymen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public Customer authenticateUser(String email, String password) {
        return authRepository.authenticateUser(email, password);
    }
}
